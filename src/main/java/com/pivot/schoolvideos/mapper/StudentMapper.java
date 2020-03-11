package com.pivot.schoolvideos.mapper;

import com.pivot.schoolvideos.dao.StuInfo;
import com.pivot.schoolvideos.dao.Student;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StudentMapper {
    @Select("select *from `stuinfo` where `studentID` = #{studentID}")
    StuInfo getStudent(String studentID);

    @Select("select *from `student` where classID = #{classID}")
    List<StuInfo> getStudents(String classID);

    @Insert("insert into `student`(`studentID`,`studentName`,`studentSex`,`studentAge`,`classID`,`tel`)" +
            " values(#{studentID},#{studentName},#{studentSex},#{studentAge},#{classID},#{tel})")
    int setStudent(Student student);

    @Delete("delete from `student` where studentID = #{studentID}")
    int delStudent(String studentID);

    @Update("update `student` set `studentName` = #{studentName},`studentAge` = #{studentAge}," +
            "`studentSex` = #{studentSex},`classID` = #{classID},`tel` = #{tel} " +
            "where `studentID` = #{studentID}")
    int updateStudent(Student student);
}
