package com.pivot.schoolvideos.mapper;

import com.pivot.schoolvideos.dao.Student;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StudentMapper {
    @Select("select *from `student` where `studentID` = #{studentID}")
    Student getStudent(String studentID);

    @Select("select *from `student` where classID = #{classID}")
    List<Student> getStudents(String classID);

    @Insert("insert into `student`(`studentID`,`studentName`,`studentSex`,`studentAge`,`classID`)" +
            " values(#{studentID},#{studentName},#{studentSex},#{studentAge},#{classID})")
    int setStudent(Student student);

    @Delete("delete from `student` where studentID = #{studentID}")
    int delStudent(String studentID);

    @Update("update `student` set `studentName` = #{studentName},`studentAge` = #{studentAge}," +
            "`studentSex` = #{studentSex},`classID` = #{classID} where `studentID` = `studentID`")
    int updateStudent(Student student);
}
