package com.pivot.schoolvideos.service;

import com.pivot.schoolvideos.dao.Student;
import com.pivot.schoolvideos.dao.User;
import com.pivot.schoolvideos.mapper.UserMapper;
import com.pivot.schoolvideos.utils.MD5;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {
    final private UserMapper userMapper;
    MD5 md5 = new MD5();

    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Transactional
    public User login(String account, String password) {
        User user = userMapper.getUser(account);
        if(user.getAccount()==null) return new User();
        if(md5.verify(password,user.getPassword())) return user;
        return new User();
    }

    @Transactional
    public int delUser(String account){
        return userMapper.delUser(account);
    }

    public User getUser(String account){
        return userMapper.getUser(account);
    }

    @Transactional
    public List<User> getTeacher(){
        return userMapper.getAllTeacher();
    }

    @Transactional
    public List<Student> getChild(String account){
        return userMapper.getChild(account);
    }

    @Transactional
    public int joinParent(User user){
        return userMapper.joinParent(user);
    }

    @Transactional
    public int alterSecret(User user,String oldPassword){
        if(!md5.verify(oldPassword,userMapper.getPwd(user).getPassword())) return 0x7ffff;
        user.setPassword(md5.getCiphertext(user.getPassword()));
        return userMapper.alterSecret(user);
    }

    @Transactional
    public int Secret(User user){
        user.setPassword(md5.getCiphertext(user.getPassword()));
        return userMapper.alterSecret(user);
    }

    @Transactional
    public int sigup(User user){
        if(userMapper.getUser(user.getAccount())!=null) return 0x7fffff;
        user.setPassword(md5.getCiphertext(user.getPassword()));
        return userMapper.setUser(user);
    }

    @Transactional
    public int setFace(User user){
        return userMapper.setFace(user);
    }

    @Transactional
    public int updateTeacher(User user){
        return userMapper.updateTeacher(user);
    }
}
