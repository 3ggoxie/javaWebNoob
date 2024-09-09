package org.example.javawebnoob.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.javawebnoob.pojo.Dept;
import org.example.javawebnoob.pojo.Result;
import org.example.javawebnoob.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class DeptController {

    //private static Logger log = LoggerFactory.getLogger(DeptController.class);

    @Autowired
    private DeptService deptService;

    @GetMapping("/depts")
    public Result list() {
        log.info("查询全部部门信息");

        List<Dept> depts = deptService.list();
        return Result.success(depts);
    }

    @DeleteMapping("/depts/{id}")
    public Result delete(@PathVariable Integer id) {
        log.info("删除部门信息, id={}", id);

        deptService.delete(id);
        return Result.success();
    }

}
