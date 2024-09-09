package org.example.javawebnoob.mapper;

import org.apache.ibatis.annotations.*;
import org.example.javawebnoob.pojo.Dept;

import java.util.List;

@Mapper
public interface DeptMapper {
    @Select("SELECT * FROM dept")
    List<Dept> list();

    @Delete("DELETE FROM dept WHERE id = #{id}")
    void deleteById(Integer id);

    @Insert("insert into dept ( name,create_time,update_time) values ( #{name},#{createTime},#{updateTime})")
    void insert(Dept dept);

    @Update("UPDATE dept SET name = #{name}, update_time = #{updateTime} WHERE id = #{id}")
    void update(Dept dept);
}
