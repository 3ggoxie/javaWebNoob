package org.example.javawebnoob.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.javawebnoob.pojo.Emp;
import org.example.javawebnoob.pojo.Result;
import org.example.javawebnoob.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private EmpService empService;

    @PostMapping
    public Result login(@RequestBody Emp emp) {
        log.info("员工登录: {}", emp);
        Emp e = empService.login(emp);
        return e != null ? Result.success() : Result.error("用户名或密码错误");
    }
}
