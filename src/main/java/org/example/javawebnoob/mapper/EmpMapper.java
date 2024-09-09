package org.example.javawebnoob.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.example.javawebnoob.pojo.Emp;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {
    //    @Select("SELECT count(*) FROM emp")
//    public Long count();
//
//    @Select("select * from emp limit #{start},#{pageSize}")
//    public List<Emp> page(Integer start,Integer pageSize);

    //    @Select("SELECT * FROM emp")
    public List<Emp> list(String name, Short gender, LocalDate begin, LocalDate end);

    void delete(List<Integer> ids);

    @Insert("insert into emp(username, name, gender, image, job, entrydate, dept_id, create_time, update_time) " +
            "values" + "(#{username},#{name},#{gender},#{image},#{job},#{entrydate},#{deptId},#{createTime}," +
            "#{updateTime})")
    void insert(Emp emp);
}
