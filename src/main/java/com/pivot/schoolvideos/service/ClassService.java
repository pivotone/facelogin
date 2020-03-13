package com.pivot.schoolvideos.service;

import com.pivot.schoolvideos.dao.Class;
import com.pivot.schoolvideos.dao.ClassInfo;
import com.pivot.schoolvideos.dao.StuInfo;
import com.pivot.schoolvideos.mapper.ClassMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClassService {
    final private ClassMapper classMapper;

    public ClassService(ClassMapper classMapper) {
        this.classMapper = classMapper;
    }

    @Transactional
    public List<ClassInfo> teachClass(String userID){
        return classMapper.teachClass(userID);
    }

    @Transactional
    public ClassInfo getClass(String classID){
        return classMapper.getClass(classID);
    }

    @Transactional
    public List<StuInfo> teachStudent(String userID){
        return classMapper.teachStudent(userID);
    }

    @Transactional
    public List<ClassInfo> getAll(){
        return classMapper.getAll();
    }

    @Transactional
    public int setClass(Class cla){
        cla.setClassID(setClassID());
        return classMapper.setClass(cla);
    }

    @Transactional
    public int alterClass(Class cla){
        return classMapper.alterClass(cla);
    }

    @Transactional
    public int delClass(String classID){
        return classMapper.delClass(classID);
    }

    public String setClassID(){
        int num = 1;
        if(classMapper.All().size()!=0){
            num = Integer.parseInt(classMapper.All().get(classMapper.All().size()-1).getClassID())+1;
        }
        StringBuilder ID = new StringBuilder(String.valueOf(num));
        while(ID.length()<4) ID.insert(0, "0");
        return String.valueOf(ID);
    }
}
