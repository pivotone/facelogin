package com.pivot.schoolvideos.controller;

import com.pivot.schoolvideos.dao.StuInfo;
import com.pivot.schoolvideos.dao.Student;
import com.pivot.schoolvideos.entity.Result;
import com.pivot.schoolvideos.service.StudentService;
import com.pivot.schoolvideos.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    final private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    //获得单个学生的信息
    @PostMapping(value = "/get", produces = "application/json;charset=UTF-8")
    public Result getStudent(String studentID){
        StuInfo student = studentService.getStudent(studentID);
        if(student.getStudentID()==null) return ResultUtils.error("3000","查询出错或此人不存在");
        else return ResultUtils.success(student);
    }

    //获得一个班级的学生信息
    @PostMapping(value = "/getClass", produces = "application/json;charset=UTF-8")
    public Result getStudents(String classID){
        List<StuInfo> students = studentService.getStudents(classID);
        if(students.size()==0) return ResultUtils.error("3100","查询出错或班级暂无成员");
        else return ResultUtils.success(students);
    }

    @PostMapping(value = "/getAll", produces = "application/json;charset=UTF-8")
    public Result getAllStudent(){
        List<StuInfo> students = studentService.getAllStudent();
        if(students.size()==0) return ResultUtils.error("3500","暂无成员");
        else return ResultUtils.success(students);
    }

    //新增学生
    @PostMapping(value = "/set", produces = "application/json;charset=UTF-8")
    public Result setStudent(String studentName,String studentSex
            ,int studentAge,String classID,String tel){
        Student student = new Student();
        student.setClassID(classID); student.setStudentAge(studentAge);
        student.setStudentSex(studentSex); student.setStudentName(studentName); student.setTel(tel);
        int result = studentService.setStudent(student);
        if(result == 0) return ResultUtils.error("3200","插入错误");
        else return ResultUtils.success();
    }

    //删除学生，慎用
    @PostMapping(value = "/del", produces = "application/json;charset=UTF-8")
    public Result delStudent(String studentID){
        int result = studentService.delStudent(studentID);
        if(result == 0) return ResultUtils.error("3300","删除错误");
        else return ResultUtils.success();
    }

    //更新信息
    @PostMapping(value = "/update", produces = "application/json;charset=UTF-8")
    public Result updateStudent(String studentID,String studentName,
                                String studentSex,int studentAge,String classID,String tel){
        Student student = new Student();
        student.setClassID(classID); student.setStudentAge(studentAge); student.setStudentID(studentID);
        student.setStudentSex(studentSex); student.setStudentName(studentName); student.setTel(tel);
        int result = studentService.updateStudent(student);
        if(result == 0) return ResultUtils.error("3400","修改错误");
        else return ResultUtils.success();
    }
}
