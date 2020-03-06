package com.pivot.schoolvideos.controller;

import com.pivot.schoolvideos.dao.Student;
import com.pivot.schoolvideos.entity.Result;
import com.pivot.schoolvideos.service.StudentService;
import com.pivot.schoolvideos.utils.ResultUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    final private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping(value = "/get", produces = "application/json:charset=UTF-8")
    public Result getStudent(String studentID){
        Student student = studentService.getStudent(studentID);
        if(student.getStudentID()==null) return ResultUtils.error("3000","查询出错或此人不存在");
        else return ResultUtils.success(student);
    }

    @PostMapping(value = "/getClass", produces = "application/json;charset=UTF-8")
    public Result getStudents(String classID){
        List<Student> students = studentService.getStudents(classID);
        if(students.size()==0) return ResultUtils.error("3100","查询出错或班级暂无成员");
        else return ResultUtils.success(students);
    }

    @PostMapping(value = "/set", produces = "application/json;charset=UTF-8")
    public Result setStudent(String studentID,String studentName,String studentSex,int studentAge,String classID){
        Student student = new Student();
        student.setClassID(classID); student.setStudentAge(studentAge); student.setStudentID(studentID);
        student.setStudentSex(studentSex); student.setStudentName(studentName);
        int result = studentService.setStudent(student);
        if(result == 0) return ResultUtils.error("3200","插入错误");
        else return ResultUtils.success();
    }

    @PostMapping(value = "/del", produces = "application/json;charset=UTF-8")
    public Result delStudent(String studentID){
        int result = studentService.delStudent(studentID);
        if(result == 0) return ResultUtils.error("3200","删除错误");
        else return ResultUtils.success();
    }

    @PostMapping(value = "/update", produces = "application/json;charset=UTF-8")
    public Result updateStudent(String studentID,String studentName,String studentSex,int studentAge,String classID){
        Student student = new Student();
        student.setClassID(classID); student.setStudentAge(studentAge); student.setStudentID(studentID);
        student.setStudentSex(studentSex); student.setStudentName(studentName);
        int result = studentService.updateStudent(student);
        if(result == 0) return ResultUtils.error("3200","修改错误");
        else return ResultUtils.success();
    }
}
