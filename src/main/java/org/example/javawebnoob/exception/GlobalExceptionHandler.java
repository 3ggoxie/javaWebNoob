package org.example.javawebnoob.exception;

import org.example.javawebnoob.pojo.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)//捕获所有异常
    public Result ex(Exception e) {
        e.printStackTrace();
        return Result.error("对不起，系统异常，请联系管理员");
    }
}
