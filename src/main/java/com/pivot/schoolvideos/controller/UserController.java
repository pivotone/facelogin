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

    //获得所有教师的信息
    @PostMapping(value = "/getTeacher", produces = "application/json;charset=UTF-8")
    public Result getTeacher(){
        List<User> users = userService.getTeacher();
        return ResultUtils.success(users);
    }

    @PostMapping(value = "/signup", produces = "application/json;charset=UTF-8")
    public Result signUp(String username,String password,int age,int roleID,
                        String sex,String account){
        if(roleID==1&&userService.getChild(account).size()==0) return ResultUtils.error("1400","你的孩子暂未登记");
        User user = new User();
        logger.info("年龄是："+ age);
        logger.info("角色是："+ roleID);
        user.setAccount(account); user.setAge(age); user.setPassword(password); user.setRoleID(roleID);
        user.setSex(sex); user.setUsername(username);
        int result = userService.sigup(user);
        if(result == 0x7fffff) return ResultUtils.error("1200","账户已被注册");
        else if(result != 0){
            user.setPassword(null);
            if(roleID == 1) {
                int res = userService.joinParent(user);
                if(res==0) return ResultUtils.error("1500","用户注册成功，但是绑定孩子失败，请登录后绑定孩子");
            }
            return ResultUtils.success(user);
        }else return ResultUtils.error("1100","注册失败");
    }

    //更新老师信息，不修改密码
    @PostMapping(value = "/updateTeacher", produces = "application/json;charset=UTF-8")
    public Result updateTeacher(User user){
        int result = userService.updateTeacher(user);
        if(result==0) return ResultUtils.error("1300","更改信息失败");
        return ResultUtils.success();
    }

    //修改密码，传参为密码（password）和ID（userID），旧密码（oldPassword）
    @PostMapping(value = "/secret", produces = "application/json;charset=UTF-8")
    public Result alterSecret(User user,String oldPassword){
        int result = userService.alterSecret(user,oldPassword);
        if(result==0) return ResultUtils.error("1600","密码修改失败");
        else if(result == 0x7ffff) return ResultUtils.error("1700","旧密码错误");
        return ResultUtils.success();
    }

    //修改密码，传参为密码（password）和ID（userID）
    @PostMapping(value = "/alter", produces = "application/json;charset=UTF-8")
    public Result Secret(User user){
        int result = userService.Secret(user);
        if(result==0) return ResultUtils.error("1600","密码修改失败");
        return ResultUtils.success();
    }
}
