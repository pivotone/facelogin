package com.pivot.schoolvideos.service;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest

class StudentServiceTest {
    @Autowired
    private StudentService studentService;

    @Test
    void getStudent() {
        System.out.println(studentService.getStudent("0001001").getStudentName());
    }

    @Test
    void getStudents() {
        System.out.println(studentService.getStudents("0001").get(1).getStudentName());
    }

    @Test
    void getAllStudent() {
        System.out.println(studentService.getAllStudent().get(2).getStudentName());
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
        System.out.println(studentService.getMood(5).getAnxious());
    }

    @Test
    void getMoods() {
        System.out.println(studentService.getMoods(5).get(0).getStudentID());
    }

    @Test
    void setStudentID() {
        System.out.println(studentService.setStudentID("0001"));
    }
}