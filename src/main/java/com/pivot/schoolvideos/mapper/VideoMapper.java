package com.pivot.schoolvideos.mapper;

import com.pivot.schoolvideos.dao.Video;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface VideoMapper {
    @Select("select *from video where `userID`=#{userID}")
    List<Video> getVideo(int userID);
}
