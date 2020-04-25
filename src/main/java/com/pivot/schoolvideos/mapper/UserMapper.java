package com.pivot.schoolvideos.mapper;

import com.pivot.schoolvideos.dao.Student;
import com.pivot.schoolvideos.dao.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {
    //登录
    @Select("select *from user where account = #{account}")
    User getUser(String account);

    @Select("select *from student where tel = #{account}")
    List<Student> getChild(String account);

    // 获得所有教师
    @Select("select *from user where roleID = 0")
    List<User> getAllTeacher();

    @Select("select password from user where userID = #{userID}")
    User getPwd(User user);

    @Update("update student set parentID = #{userID} where tel = #{account}")
    int joinParent(User user);

    @Update("update user set password = #{password} where userID = #{userID}")
    int alterSecret(User user);

    //插入教师和家长注册
    @Insert("insert into user(`username`,`account`,`password`,`sex`,`age`,`roleID`,`facedata`) " +
            "values(#{username},#{account},#{password},#{sex},#{age},#{roleID},#{facedata})")
    @Options(useGeneratedKeys = true, keyProperty = "userID", keyColumn = "userID")
    int setUser(User user);

    //上传人脸信息
    @Update("update user set facedata = #{facedata} where account = #{account}")
    int setFace(User user);

    //更改教师
    @Update("update user set username = #{username}, age = #{age}, sex = #{sex}" +
            " where userID = #{userID} and roleID = 0")
    int updateTeacher(User user);

    @Delete("delete from user where account = #{account}")
    int delUser(String account);
}
