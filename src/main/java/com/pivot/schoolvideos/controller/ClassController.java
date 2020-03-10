package com.pivot.schoolvideos.controller;

import com.pivot.schoolvideos.dao.Class;
import com.pivot.schoolvideos.dao.ClassInfo;
import com.pivot.schoolvideos.entity.Result;
import com.pivot.schoolvideos.service.ClassService;
import com.pivot.schoolvideos.utils.ResultUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/class")
public class ClassController {
    final private ClassService classService;

    public ClassController(ClassService classService) {
        this.classService = classService;
    }

    @PostMapping(value = "/get",produces = "application/json;charset=UTF-8")
    public Result getClass(String classID){
        ClassInfo classInfo = classService.getClass(classID);
        if(classInfo.getClassID()==null) return ResultUtils.error("4000","班级编码不存在");
        else return ResultUtils.success(classInfo);
    }

    @PostMapping(value = "/getAll",produces = "application/json;charset=UTF-8")
    public Result getAll(){
        List<ClassInfo> classInfos = classService.getAll();
        if(classInfos.size()==0) return ResultUtils.error("4100","暂无班级");
        return ResultUtils.success(classInfos);
    }

    @PostMapping(value = "/set",produces = "application/json;charset=UTF-8")
    public Result setClass(String classID,String className,String teacherID){
        Class cla = new Class();
        cla.setClassID(classID); cla.setClassName(className); cla.setTeacherID(teacherID);
        int result = classService.setClass(cla);
        if(result==0)return ResultUtils.error("4200","新增班级失败");
        return ResultUtils.success();
    }

    @PostMapping(value = "/update",produces = "application/json;charset=UTF-8")
    public Result alterClass(String classID,String className,String teacherID){
        Class cla = new Class();
        cla.setClassID(classID); cla.setClassName(className); cla.setTeacherID(teacherID);
        int result = classService.alterClass(cla);
        if(result==0)return ResultUtils.error("4200","更改班级失败");
        return ResultUtils.success();
    }

    @PostMapping(value = "/del",produces = "application/json;charset=UTF-8")
    public Result delClass(String classID){
        int result = classService.delClass(classID);
        if(result==0)return ResultUtils.error("4200","删除班级失败");
        return ResultUtils.success();
    }
}