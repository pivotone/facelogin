package com.pivot.schoolvideos.service;

import com.pivot.schoolvideos.dao.Mood;
import com.pivot.schoolvideos.dao.MoodInfo;
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
    public List<StuInfo> getAllStudent(){
        return studentMapper.getAllStudent();
    }

    @Transactional
    public int setStudent(Student student){
        student.setStudentID(setStudentID(student.getClassID()));
        return studentMapper.setStudent(student);
    }

    @Transactional
    public int delStudent(String studentID){
        return studentMapper.delStudent(studentID);
    }

    @Transactional
    public int updateStudent(Student student){
        student.setID(student.getStudentID());
        if(!student.getClassID().equals(studentMapper.getStudent(student.getStudentID()).getClassID())) {
            student.setStudentID(setStudentID(student.getClassID()));
        }
        return studentMapper.updateStudent(student);
    }

    private String setStudentID(String classID){
        int num = 1;
        if(studentMapper.Students(classID).size()!=0){
            num = Integer.parseInt(studentMapper.Students(classID)
                    .get(studentMapper.Students(classID).size()-1).getStudentID().substring(4)) + 1;
        }
        StringBuilder ID = new StringBuilder(String.valueOf(num));
        while(ID.length()<3) ID.insert(0, "0");
        ID.insert(0,classID);
        return String.valueOf(ID);
    }

    @Transactional
    public MoodInfo getMood(Mood mood){
        return studentMapper.getMood(mood);
    }

    @Transactional
    public List<MoodInfo> getMoods(String studentID){
        return studentMapper.getMoods(studentID);
    }
}
