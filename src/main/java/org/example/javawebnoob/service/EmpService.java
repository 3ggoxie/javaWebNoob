package org.example.javawebnoob.service;

import org.example.javawebnoob.pojo.PageBean;

import java.time.LocalDate;

public interface EmpService {
    PageBean page(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end);
}
