package org.example.javawebnoob.service;

import org.example.javawebnoob.pojo.PageBean;

public interface EmpService {
    PageBean page(Integer page, Integer pageSize);
}
