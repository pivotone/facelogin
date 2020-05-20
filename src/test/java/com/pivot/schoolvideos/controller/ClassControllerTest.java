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
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

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
                .accept(MediaType.APPLICATION_JSON).param("userID","33"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());
    }

    @Test
    void teachStudent() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(classController).build();
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/class/teachAll")
                .accept(MediaType.APPLICATION_JSON).param("userID","33"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());
    }

    @Test
    void getAll() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(classController).build();
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/class/getAll"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());
    }

    @Transactional
    @Test
    void setClass() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(classController).build();
        MultiValueMap<String,String> map = new LinkedMultiValueMap<>();
        map.add("className","1");
        map.add("teacherID","1");
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/class/set")
                .accept(MediaType.APPLICATION_JSON)
                .params(map))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());
    }

    @Transactional
    @Test
    void alterClass() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(classController).build();
        MultiValueMap<String,String> map = new LinkedMultiValueMap<>();
        map.add("classID","0008");
        map.add("className","medium2");
        map.add("teacherID","1");
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/class/update")
                .accept(MediaType.APPLICATION_JSON)
                .params(map))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());
    }

    @Transactional
    @Test
    void delClass() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(classController).build();
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/class/del")
                .accept(MediaType.APPLICATION_JSON).param("classID","0009"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());
    }
}