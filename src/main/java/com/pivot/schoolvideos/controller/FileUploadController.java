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
import java.io.InputStreamReader;
import java.io.LineNumberReader;

@RestController
@RequestMapping("/file")
public class FileUploadController {
    private static final Logger logger = LoggerFactory.getLogger(FileUploadController.class);
    private String uploader;
    private final UserService userService;

    public FileUploadController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/upload")//, produces = "multipart/from-data")
    public Result uploadFile(@RequestParam(value = "file")MultipartFile file){
        if(file.isEmpty()){
            userService.delUser(file.getOriginalFilename().substring(0,file.getOriginalFilename().lastIndexOf(".")));
            return ResultUtils.error("2000","文件为空");
        }
        String fileName = file.getOriginalFilename();
        logger.info("文件名为: "+fileName);
        String faceData = fileName.substring(0,fileName.lastIndexOf("."));
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        logger.info("文件后缀为："+suffixName);
        String filePath = "D:/idea_folder/pic/pic/";
        File dest = new File(filePath+fileName);
        if(!dest.getParentFile().exists()){
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
            logger.info("上传成功的文件路径： "+ filePath + fileName);
            String args[] = new String[] {"python","D:/idea_folder/schoolvideos/src/main/resources/python/crop_encoding.py",faceData};
            Process process = Runtime.getRuntime().exec(args);
            int status = process.waitFor();
            logger.info(""+status);
//            if(status==1) {
//                userService.delUser(faceData);
//                return ResultUtils.error("2300","特征提取失败,注册信息删除");
//            }
            User user = new User();
            user.setFacedata(filePath+fileName);user.setAccount(faceData);
            int result = userService.setFace(user);
            if(result == 1) return ResultUtils.success();
            else {
                userService.delUser(faceData);
                return ResultUtils.error("2200","地址写入失败");
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        userService.delUser(faceData);
        return ResultUtils.error("2100","文件上传失败");
    }

    @PostMapping(value = "/login")
    public Result login(@RequestParam(value = "file")MultipartFile file) throws IOException, InterruptedException {
        if(file.isEmpty()){
            return ResultUtils.error("2000","登录失败");
        }
        String fileName = file.getOriginalFilename();
        logger.info("文件名为: "+fileName);
//        String suffixName = fileName.substring(fileName.lastIndexOf("."));
//        logger.info("文件后缀为："+suffixName);
        String filePath = "D:/idea_folder/pic/pic/";
        File dest = new File(filePath+fileName);
        if(!dest.getParentFile().exists()){
            dest.getParentFile().mkdirs();
        }
        file.transferTo(dest);
        String[] args=new String[] {"python","D:/idea_folder/schoolvideos/src/main/resources/python/facerec.py",fileName};
        Process process=Runtime.getRuntime().exec(args);
        int status=process.waitFor();
        InputStreamReader ir=new InputStreamReader(process.getInputStream());
        LineNumberReader input=new LineNumberReader(ir);
        String result=input.readLine();
        dest.delete();
        if(status==1){
            return ResultUtils.error("2400","没有发现人脸");
        }else if(result.equals("-1")){
            return ResultUtils.error("2500","没有识别出人脸");
        }else{
            return ResultUtils.success(userService.getUser(result));
        }
    }
}
