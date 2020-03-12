package com.pivot.schoolvideos.mapper;

import com.pivot.schoolvideos.dao.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {
    @Select("select *from user where account = #{account}")
    User getUser(String account);

    @Select("select userID,username from user where roleID = 0")
    List<User> getAllTeacher();

    @Insert("insert into user(`username`,`account`,`password`,`sex`,`age`,`roleID`,`facedata`) " +
            "values(#{username},#{account},#{password},#{sex},#{age},#{roleID},#{facedata})")
    int setUser(User user);
}
