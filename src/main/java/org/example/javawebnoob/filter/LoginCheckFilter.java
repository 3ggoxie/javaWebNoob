package org.example.javawebnoob.filter;


import com.alibaba.fastjson.JSONObject;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.example.javawebnoob.pojo.Result;
import org.example.javawebnoob.utils.JwtUtils;
import org.springframework.util.StringUtils;

import java.io.IOException;

@Slf4j
@WebFilter(urlPatterns = "/*")
public class LoginCheckFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        String url = req.getRequestURL().toString();
        log.info("请求的url: {}", url);

        if (url.contains("login")) {
            log.info("登录页面，放行。。。");
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        String token = req.getHeader("token");

        if (!StringUtils.hasLength(token)) {
            log.info("token为空，返回未登录的信息");
            Result error = Result.error("NOT_LOGIN");
            String notLogin = JSONObject.toJSONString(error);
            resp.getWriter().write(notLogin);
            return;
        }

        try {
            JwtUtils.parseJWT(token);
        } catch (Exception e) {
            e.printStackTrace();
            log.info("token解析失败，返回未登录的信息");
            Result error = Result.error("NOT_LOGIN");
            String notLogin = JSONObject.toJSONString(error);
            resp.getWriter().write(notLogin);
            return;
        }
        log.info("token合法，放行。。。");
        filterChain.doFilter(servletRequest, servletResponse);
    }
}



