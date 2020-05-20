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
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest

class StudentControllerTest {
    @Autowired
    private StudentController studentController;

    private MockMvc mockMvc;

    @Test
    void getStudent() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(studentController).build();
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/student/get")
                .accept(MediaType.APPLICATION_JSON).param("studentID","0001001"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());
    }

    @Test
    void getStudents() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(studentController).build();
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/student/getClass")
                .accept(MediaType.APPLICATION_JSON).param("classID","0001"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());
    }

    @Test
    void getAllStudent() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(studentController).build();
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/student/getAll"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());
    }

    @Transactional
    @Test
    void setStudent() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(studentController).build();
        MultiValueMap<String,String> map = new LinkedMultiValueMap<>();
        map.add("studentName","老番茄");
        map.add("classID","0008");
        map.add("studentSex","男");
        map.add("studentAge","5");
        map.add("tel","10982039783");
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/student/set")
                .accept(MediaType.APPLICATION_JSON)
                .params(map))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());
    }

    @Transactional
    @Test
    void delStudent() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(studentController).build();
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/student/del")
                .accept(MediaType.APPLICATION_JSON)
                .param("studentID","0008001"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());
    }

    @Transactional
    @Test
    void updateStudent() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(studentController).build();
        MultiValueMap<String,String> map = new LinkedMultiValueMap<>();
        map.add("studentID","0008001");
        map.add("studentName","老番茄");
        map.add("classID","0008");
        map.add("studentSex","男");
        map.add("studentAge","5");
        map.add("tel","10982039783");
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/student/update")
                .accept(MediaType.APPLICATION_JSON)
                .params(map))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());
    }

    @Test
    void getMood() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(studentController).build();
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/student/getMood")
                .accept(MediaType.APPLICATION_JSON)
                .param("userID","5"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());
    }

    @Test
    void getMoods() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(studentController).build();
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/student/getMoods")
                .accept(MediaType.APPLICATION_JSON)
                .param("userID","5"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());
    }
}