package com.pivot.schoolvideos.service;

import com.pivot.schoolvideos.dao.StuInfo;
import com.pivot.schoolvideos.dao.Student;
import com.pivot.schoolvideos.mapper.StudentMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentService {
    final private StudentMapper studentMapper;

    public StudentService(StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }

    @Transactional
    public StuInfo getStudent(String studentID){
        return studentMapper.getStudent(studentID);
    }

    @Transactional
    public List<StuInfo> getStudents(String classID){
        return studentMapper.getStudents(classID);
    }

    @Transactional
    public int setStudent(Student student){
        return studentMapper.setStudent(student);
    }

    @Transactional
    public int delStudent(String studentID){
        return studentMapper.delStudent(studentID);
    }

    @Transactional
    public int updateStudent(Student student){
        return studentMapper.updateStudent(student);
    }
}
