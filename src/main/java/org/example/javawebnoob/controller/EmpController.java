package org.example.javawebnoob.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.javawebnoob.pojo.PageBean;
import org.example.javawebnoob.pojo.Result;
import org.example.javawebnoob.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/emps")
public class EmpController {

    @Autowired
    private EmpService empService;

    @GetMapping
    public Result page(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer pageSize) {
        log.info("分页查询,page: {}, pageSize: {}", page, pageSize);
        PageBean pageBean = empService.page(page, pageSize);
        return Result.success(pageBean);
    }

}
