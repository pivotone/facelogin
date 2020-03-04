package com.pivot.schoolvideos.controller;

import com.pivot.schoolvideos.dao.Video;
import com.pivot.schoolvideos.entity.Result;
import com.pivot.schoolvideos.service.VideoService;
import com.pivot.schoolvideos.utils.ResultUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/video")
public class VideoController {
    final private VideoService videoService;

    public VideoController(VideoService videoService) {
        this.videoService = videoService;
    }

    @PostMapping(value = "/get", produces = "application/json;charset=UTF-8")
    public Result getVideo(int userID){
        List<Video> videos = videoService.getVideo(userID);
        return ResultUtils.success(videos);
    }
}
