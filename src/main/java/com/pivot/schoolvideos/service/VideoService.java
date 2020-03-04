package com.pivot.schoolvideos.service;

import com.pivot.schoolvideos.dao.Video;
import com.pivot.schoolvideos.mapper.VideoMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VideoService {
    final private VideoMapper videoMapper;

    public VideoService(VideoMapper videoMapper) {
        this.videoMapper = videoMapper;
    }

    @Transactional
    public List<Video> getVideo(int userID){
        return videoMapper.getVideo(userID);
    }
}
