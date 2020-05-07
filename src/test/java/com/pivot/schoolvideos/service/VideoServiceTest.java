package com.pivot.schoolvideos.service;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest

class VideoServiceTest {
    @Autowired
    private VideoService videoService;

    @Test
    void getVideo() {
        System.out.println(videoService.getVideo(5).get(0).getVideoDesc());
    }
}