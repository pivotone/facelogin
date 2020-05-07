package com.pivot.schoolvideos.service;

import com.pivot.schoolvideos.dao.User;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest

class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    void login() {
        System.out.println(userService.login("15056911226","1").getUsername());
    }

    @Test
    void delUser() {
        System.out.println("test 1-------");
    }

    @Test
    void getUser() {
        assert userService.getUser("15056911226").getAccount().equals("15056911226"):"error";
    }

    @Test
    void getTeacher() {
        System.out.println(userService.getTeacher().get(0).getUsername());
    }

    @Test
    void getChild() {
        System.out.println(userService.getChild("16776765765").get(0).getStudentName());
    }

    @Test
    void joinParent() {
        System.out.println("test 2--------");
    }

    @Test
    void alterSecret() {
        User user = new User();
        user.setUserID(1);
        user.setPassword("1");
        assert userService.alterSecret(user,"1")==1:"error";
    }

    @Test
    void secret() {
        User user = new User();
        user.setUserID(1);
        user.setPassword("1");
        assert userService.Secret(user)==1:"error";
    }

    @Test
    void sigup() {
        System.out.println("test 3----------");
    }

    @Test
    void setFace() {
        System.out.println("test 4----------");
    }

    @Test
    void updateTeacher() {
        System.out.println("test 5---------");
    }
}