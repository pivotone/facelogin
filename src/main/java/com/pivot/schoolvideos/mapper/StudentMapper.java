package com.pivot.schoolvideos.mapper;

import com.pivot.schoolvideos.dao.Mood;
import com.pivot.schoolvideos.dao.MoodInfo;
import com.pivot.schoolvideos.dao.StuInfo;
import com.pivot.schoolvideos.dao.Student;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StudentMapper {
    //获得单个学生信息
    @Select("select *from `stuinfo` where `studentID` = #{studentID}")
    StuInfo getStudent(String studentID);

    //获得一个班级的所有学生
    @Select("select *from `stuinfo` where classID = #{classID}")
    List<StuInfo> getStudents(String classID);

    // get all student
    @Select("select *from `stuinfo`")
    List<StuInfo> getAllStudent();

    //学生编号，前端不需要处理
    @Select("select *from `stuinfo` where classID = #{classID} order by studentID")
    List<StuInfo> Students(String classID);

    //插入学生
    @Insert("insert into `student`(`studentID`,`studentName`,`studentSex`,`studentAge`,`classID`,`tel`,createDate)" +
            " values(#{studentID},#{studentName},#{studentSex},#{studentAge},#{classID},#{tel},NOW())")
    int setStudent(Student student);

    //删除学生，慎重使用
    @Delete("delete from `student` where studentID = #{studentID}")
    int delStudent(String studentID);

    //更新学生
    @Update("update `student` set `studentName` = #{studentName},`studentAge` = #{studentAge}," +
            "`studentSex` = #{studentSex},`classID` = #{classID},`tel` = #{tel} " +
            ",`studentID` = #{studentID} where `studentID` = #{ID}")
    int updateStudent(Student student);

    @Select("select *from moodinfo where studentID = #{studentID} and createDate = #{createDate}")
    MoodInfo getMood(Mood mood);

    @Select("select *from moodinfo where studentID = #{studentID} order by createDate limit 7")
    List<MoodInfo> getMoods(String studentID);

}
