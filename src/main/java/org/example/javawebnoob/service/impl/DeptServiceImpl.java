package org.example.javawebnoob.service.impl;

import org.example.javawebnoob.mapper.DeptMapper;
import org.example.javawebnoob.mapper.EmpMapper;
import org.example.javawebnoob.pojo.Dept;
import org.example.javawebnoob.pojo.DeptLog;
import org.example.javawebnoob.service.DeptLogService;
import org.example.javawebnoob.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;
    @Autowired
    private EmpMapper empMapper;
    @Autowired
    private DeptLogService DeptLogService;

    @Override
    public List<Dept> list() {
        return deptMapper.list();
    }

    //    @Transactional(rollbackFor = Exception.class)
    @Transactional
    @Override
    public void delete(Integer id) throws Exception {
        try {
            deptMapper.deleteById(id);
//            int i = 1 / 0; // for test
//        if (true) {
//            throw new Exception("出错啦。。");
//        }
            empMapper.deleteByDeptId(id);
        } finally {
            DeptLog log = new DeptLog();
            log.setCreateTime(LocalDateTime.now());
            log.setDescription("执行了解散部门的操作，此次解散的是" + id + "号部门");
            DeptLogService.insert(log);
        }
    }

    @Override
    public void add(Dept dept) {
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.insert(dept);
    }

    @Override
    public void update(Dept dept) {
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.update(dept);
    }

    @Override
    public Dept getById(Integer id) {
        return deptMapper.getById(id);
    }
}
