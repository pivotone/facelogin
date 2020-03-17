package com.pivot.schoolvideos.controller;

import com.pivot.schoolvideos.dao.User;
import com.pivot.schoolvideos.entity.Result;
import com.pivot.schoolvideos.service.UserService;
import com.pivot.schoolvideos.utils.ResultUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    final private UserService userService;
    private static final Logger logger = LoggerFactory.getLogger(FileUploadController.class);

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/login", produces = "application/json;charset=UTF-8")
    public Result login(String account,String password){
        User user = userService.login(account,password);
        user.setPassword(null);
        if(user.getAccount()==null) return ResultUtils.error("1000","账号或密码错误");
        else return ResultUtils.success(user);
    }

    @PostMapping(value = "/getTeacher", produces = "application/json;charset=UTF-8")
    public Result getTeacher(){
        List<User> users = userService.getTeacher();
        return ResultUtils.success(users);
    }

    @PostMapping(value = "/signup", produces = "application/json;charset=UTF-8")
    public Result signUp(String username,String password,int age,int roleID,
                        String sex,String account){
        User user = new User();
        logger.info("年龄是："+ age);
        logger.info("角色是："+ roleID);
        user.setAccount(account); user.setAge(age); user.setPassword(password); user.setRoleID(roleID);
        user.setSex(sex); user.setUsername(username);
        int result = userService.sigup(user);
        if(result == 0x7fffff) return ResultUtils.error("1200","账户已被注册");
        else if(result != 0){
            user.setPassword(null);
            return ResultUtils.success(user);
        }else return ResultUtils.error("1100","注册失败");
    }

    @PostMapping(value = "/updateTeacher", produces = "application/json;charset=UTF-8")
    public Result updateTeacher(User user){
        int result = userService.updateTeacher(user);
        if(result==0) return ResultUtils.error("1300","更改信息失败");
        return ResultUtils.success();
    }
}
