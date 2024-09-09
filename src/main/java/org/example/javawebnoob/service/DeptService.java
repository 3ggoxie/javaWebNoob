package org.example.javawebnoob.service;

import org.example.javawebnoob.pojo.Dept;

import java.util.List;

public interface DeptService {
    List<Dept> list();

    void delete(Integer id);
}
