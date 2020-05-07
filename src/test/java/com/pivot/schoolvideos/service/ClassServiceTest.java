package com.pivot.schoolvideos.service;

import com.pivot.schoolvideos.dao.Class;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest

class ClassServiceTest {
    @Autowired
    private ClassService classService;

    @Test
    void teachClass() {
        System.out.println(classService.teachClass("4").get(0).getClassID());
    }

    @Test
    void testGetClass() {
        System.out.println(classService.getClass("0001").getClassName());
    }

    @Test
    void teachStudent() {
        System.out.println(classService.teachStudent("4").get(0).getStudentName());
    }

    @Test
    void getAll() {
        System.out.println(classService.getAll().get(0).getClassID());
    }

    @Test
    void setClass() {
        Class klass = new Class();
        klass.setClassName("xiao");
        klass.setTeacherID("4");
        assert classService.setClass(klass)==1:"error";
    }

    @Test
    void alterClass() {
        Class klass = new Class();
        klass.setClassName("xiao");
        klass.setTeacherID("4");
        klass.setClassID("0009");
        assert classService.alterClass(klass)==1:"error";
    }

    @Test
    void delClass() {
        assert classService.delClass("0009")==1:"error";
    }

    @Test
    void setClassID() {
        System.out.println(classService.setClassID());
    }
}