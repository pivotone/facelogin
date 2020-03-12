package com.pivot.schoolvideos.mapper;

import com.pivot.schoolvideos.dao.Class;
import com.pivot.schoolvideos.dao.ClassInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ClassMapper {
    @Select("select *from classinfo where `classID` = #{classID}")
    ClassInfo getClass(String classID);

    @Select("select *from classinfo where `teacherID` = #{userID}")
    List<ClassInfo> teachClass(String userID);

    @Select("select *from classinfo")
    List<ClassInfo> getAll();

    @Insert("insert into `class`(classID,className,teacherID,createDate) " +
            "values(#{classID},#{className},#{teacherID},NOW())")
    int setClass(Class cla);

    @Update("update `class` set className = #{className},teacherID = #{teacherID} where classID = #{classID}")
    int alterClass(Class cla);

    @Delete("delete from `class` where classID = #{classID}")
    int delClass(String classID);
}
