package org.example.javawebnoob.service.impl;


import org.example.javawebnoob.mapper.DeptLogMapper;
import org.example.javawebnoob.pojo.DeptLog;
import org.example.javawebnoob.service.DeptLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DeptLogServiceImpl implements DeptLogService {

    @Autowired
    private DeptLogMapper deptLogMapper;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public void insert(DeptLog deptLog) {

        deptLogMapper.insert(deptLog);
    }
}
