package org.example.javawebnoob.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.javawebnoob.pojo.Emp;

import java.util.List;

@Mapper
public interface EmpMapper {
    @Select("SELECT count(*) FROM emp")
    public Long count();

    @Select("select * from emp limit #{start},#{pageSize}")
    public List<Emp> page(Integer start,Integer pageSize);
}
