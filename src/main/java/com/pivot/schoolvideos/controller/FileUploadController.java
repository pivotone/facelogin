package com.pivot.schoolvideos.controller;

import com.pivot.schoolvideos.entity.Result;
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

@RestController
@RequestMapping("/file")
public class FileUploadController {
    private static final Logger logger = LoggerFactory.getLogger(FileUploadController.class);
    private String uploader;

    @PostMapping(value = "/upload")//, produces = "multipart/from-data")
    public Result uploadFile(@RequestParam(value = "file")MultipartFile file){
        if(file.isEmpty()){
            return ResultUtils.error("2000","文件为空");
        }
        String fileName = file.getOriginalFilename();
        logger.info("文件名为: "+fileName);
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        logger.info("文件后缀为："+suffixName);
        String filePath = "/pic/";
        File dest = new File(filePath+fileName);
        if(!dest.getParentFile().exists()){
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
            logger.info("上传成功的文件路径： "+ filePath + fileName);
            return ResultUtils.success();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResultUtils.error("2100","文件上传失败");
    }
}
