package com.pivot.schoolvideos.mapper;

import com.pivot.schoolvideos.dao.SignIn;
import com.pivot.schoolvideos.dao.SignRecord;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SignMapper {
    @Insert("insert into signin(`creator`,`createDate`,`description`,`duration`,createDate)" +
            " values(#{creator},#{createDate},#{description},#{duration},NOW())")
    int setSign(SignIn signIn);

    @Insert("insert into signrecord(`studentID`,`studentName`,`signID`,signDate) " +
            "values(#{studentID},#{studentName},#{signID},NOW())")
    int signIn(SignRecord signRecord);

    @Select("select *from signin where creator = #{creator}")
    List<SignIn> getSign(String creator);

    @Select("select *from signrecord where signID = #{signID}")
    List<SignRecord> getRecord(int signID);
}
