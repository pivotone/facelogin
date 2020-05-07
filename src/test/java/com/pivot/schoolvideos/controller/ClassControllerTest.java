package com.pivot.schoolvideos.controller;

import com.pivot.schoolvideos.dao.Class;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.io.UnsupportedEncodingException;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest

class ClassControllerTest {
    @Autowired
    private ClassController classController;

    private MockMvc mockMvc;

    //    @Before
//    public void setup(){
//        this.mockMvc = MockMvcBuilders.standaloneSetup(classController).build();
//    }

    @Test
    void testGetClass() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(classController).build();
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/class/get")
                .accept(MediaType.APPLICATION_JSON).param("classID","0001"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());
    }

    @Test
    void teachClass() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(classController).build();
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/class/teachGet")
                .accept(MediaType.APPLICATION_JSON).param("classID","0001"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());
    }

    @Test
    void teachStudent() {
        System.out.println(classController.teachStudent("33").getData().toString());
    }

    @Test
    void getAll() {
        System.out.println(classController.getAll());
    }

    @Test
    void setClass() {
        System.out.println(classController.setClass("1","1").getCode());
    }

    @Test
    void alterClass() {
        System.out.println(classController.alterClass("0009","xiao1","1").getCode());
    }

    @Test
    void delClass() {
        System.out.println(classController.delClass("0009").getCode());
    }
}