package com.pivot.schoolvideos.mapper;

import com.pivot.schoolvideos.dao.Class;
import com.pivot.schoolvideos.dao.ClassInfo;
import com.pivot.schoolvideos.dao.StuInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ClassMapper {
    // 查看单个班级信息
    @Select("select *from classinfo where `classID` = #{classID}")
    ClassInfo getClass(String classID);

    //查看老师管理班级的信息
    @Select("select *from classinfo where `teacherID` = #{userID}")
    List<ClassInfo> teachClass(String userID);

    //查看老师所有的学生信息
    @Select("select *from stuinfo where `teacherID` = #{userID}")
    List<StuInfo> teachStudent(String userID);

    //查看所有班级信息
    @Select("select *from classinfo")
    List<ClassInfo> getAll();

    //班级编号，前端不需要处理
    @Select("select *from classinfo order by classID")
    List<ClassInfo> All();

    //设置班级
    @Insert("insert into `class`(classID,className,teacherID,createDate) " +
            "values(#{classID},#{className},#{teacherID},NOW())")
    int setClass(Class cla);

    // 更新班级信息
    @Update("update `class` set className = #{className},teacherID = #{teacherID} where classID = #{classID}")
    int alterClass(Class cla);

    //删除班级，不建议使用
    @Delete("delete from `class` where classID = #{classID}")
    int delClass(String classID);
}
