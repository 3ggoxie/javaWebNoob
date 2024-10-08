package org.example.javawebnoob.service;

import org.example.javawebnoob.pojo.Dept;

import java.util.List;

public interface DeptService {
    List<Dept> list();

    void delete(Integer id) throws Exception;

    void add(Dept dept);

    void update(Dept dept);

    Dept getById(Integer id);
}
