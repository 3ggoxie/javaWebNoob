package org.example.javawebnoob.aop;

import com.alibaba.fastjson.JSONObject;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.example.javawebnoob.mapper.OperateLogMapper;
import org.example.javawebnoob.pojo.OperateLog;
import org.example.javawebnoob.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;

// 定义一个日志切面类，用于记录操作日志
@Aspect
@Component
@Slf4j
public class LogAspect {
    // 自动注入操作日志Mapper
    @Autowired
    private OperateLogMapper operateLogMapper;

    // 自动注入HttpServletRequest对象
    @Autowired
    private HttpServletRequest request;

    // 定义一个环绕通知，用于在标注了@Log注解的方法执行前后记录日志
    @Around("@annotation(org.example.javawebnoob.anno.Log)")
    public Object recordLog(ProceedingJoinPoint joinPoint) throws Throwable {
        // 从请求头中获取JWT令牌
        String jwToken = request.getHeader("token");
        // 解析JWT令牌，获取Claims对象
        Claims claims = JwtUtils.parseJWT(jwToken);
        // 从Claims对象中获取操作用户ID
        Integer operateUser = (Integer) claims.get("id");

        // 获取当前操作时间
        LocalDateTime operateTime = LocalDateTime.now();

        // 获取目标类的全限定名
        String className = joinPoint.getTarget().getClass().getName();

        // 获取方法名
        String methodName = joinPoint.getSignature().getName();

        // 获取方法参数
        Object[] args = joinPoint.getArgs();
        String methodParams = Arrays.toString(args);

        // 记录方法执行开始时间
        long begin = System.currentTimeMillis();
        // 执行目标方法
        Object result = joinPoint.proceed();
        // 记录方法执行结束时间
        long end = System.currentTimeMillis();

        // 将方法返回值转换为JSON字符串
        String returnValue = JSONObject.toJSONString(result);

        // 计算方法执行耗时
        long costTime = end - begin;

        // 创建操作日志对象并封装信息
        OperateLog operateLog = new OperateLog(null, operateUser, operateTime, className, methodName, methodParams,
                returnValue, costTime);
        // 插入操作日志到数据库
        operateLogMapper.insert(operateLog);

        // 记录日志信息
        log.info("aop记录操作日志：{}", operateLog);

        // 返回目标方法的执行结果
        return result;
    }
}

