package org.example.javawebnoob.service.impl;

import org.example.javawebnoob.mapper.DeptMapper;
import org.example.javawebnoob.pojo.Dept;
import org.example.javawebnoob.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;

    @Override
    public List<Dept> list() {
        return deptMapper.list();
    }
}
