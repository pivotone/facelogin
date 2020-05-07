package com.pivot.schoolvideos.controller;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest

class StudentControllerTest {
    @Autowired
    private StudentController studentController;

    @Test
    void getStudent() {
        System.out.println(studentController.getStudent("0001001").getData());
    }

    @Test
    void getStudents() {
        System.out.println(studentController.getStudents("0001").getMessage());
    }

    @Test
    void getAllStudent() {
        System.out.println(studentController.getAllStudent().getCode());
    }

    @Test
    void setStudent() {
        System.out.println("test 1-------");
    }

    @Test
    void delStudent() {
        System.out.println("test 2-------");
    }

    @Test
    void updateStudent() {
        System.out.println("test 3-------");
    }

    @Test
    void getMood() {
        System.out.println(studentController.getMood(5).toString());
    }

    @Test
    void getMoods() {
        System.out.println(studentController.getMoods(5).toString());
    }
}