package com.pivot.schoolvideos.controller;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest

class VideoControllerTest {
    @Autowired
    private VideoController videoController;

    @Test
    void getVideo() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(videoController).build();
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/video/get")
                .accept(MediaType.APPLICATION_JSON).param("userID","2"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());
    }
}