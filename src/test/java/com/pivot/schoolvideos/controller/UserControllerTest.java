package com.pivot.schoolvideos.controller;

import com.pivot.schoolvideos.dao.User;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONParser;
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

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest

class UserControllerTest {
    @Autowired
    private UserController userController;

    private MockMvc mockMvc;

    @Test
    void login() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
        MultiValueMap<String,String> map = new LinkedMultiValueMap<>();
        map.add("account","15056911226");
        map.add("password","1");
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/user/login")
                .accept(MediaType.APPLICATION_JSON)
                .params(map))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());
    }

    @Test
    void getTeacher() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/user/getTeacher"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());
    }

    @Transactional
    @Test
    void signUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
        MultiValueMap<String,String> map = new LinkedMultiValueMap<>();
        map.add("account","15364211699");
        map.add("password","1");
        map.add("age","26");
        map.add("roleID","2");
        map.add("sex","男");
        map.add("username","刘铄");
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/user/signup")
                .accept(MediaType.APPLICATION_JSON)
                .params(map))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());
    }

    @Transactional
    @Test
    void updateTeacher() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
        MultiValueMap<String,String> map = new LinkedMultiValueMap<>();
        map.add("userID","1");
        map.add("age","26");
        map.add("sex","男");
        map.add("username","张航");
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/user/updateTeacher")
                .accept(MediaType.APPLICATION_JSON)
                .params(map))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());
    }

    @Transactional
    @Test
    void alterSecret() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
        MultiValueMap<String,String> map = new LinkedMultiValueMap<>();
        map.add("userID","1");
        map.add("password","2");
        map.add("oldPassword","1");
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/user/secret")
                .accept(MediaType.APPLICATION_JSON)
                .params(map))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());
    }

    @Transactional
    @Test
    void secret() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
        MultiValueMap<String,String> map = new LinkedMultiValueMap<>();
        map.add("userID","1");
        map.add("password","2");
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/user/alter")
                .accept(MediaType.APPLICATION_JSON)
                .params(map))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());
    }
}