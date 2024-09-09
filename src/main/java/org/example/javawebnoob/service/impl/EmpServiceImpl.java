package org.example.javawebnoob.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.example.javawebnoob.mapper.EmpMapper;
import org.example.javawebnoob.pojo.Emp;
import org.example.javawebnoob.pojo.PageBean;
import org.example.javawebnoob.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;

    //    @Override
//    public PageBean page(Integer page, Integer pageSize) {
//        PageBean pageBean = new PageBean();
//        pageBean.setTotal(empMapper.count());
//        pageBean.setRows(empMapper.page(pageSize * (page - 1), pageSize));
//        return pageBean;
//    }
    @Override
    public PageBean page(Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        List<Emp> empList = empMapper.list();
        Page<Emp> p = (Page<Emp>) empList;
        PageBean pageBean = new PageBean(p.getTotal(), p.getResult());
        return pageBean;
    }
}
