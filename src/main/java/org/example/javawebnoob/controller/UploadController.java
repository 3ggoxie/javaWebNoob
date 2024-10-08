package org.example.javawebnoob.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.javawebnoob.pojo.Result;
import org.example.javawebnoob.utils.AliOSSUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@Slf4j
public class UploadController {
//    @PostMapping("/upload")
//    public Result upload(String username, Integer age, MultipartFile image) throws IOException {
//        log.info("上传文件: username={}, age={}, image={}", username, age, image);

    ///**
// * 文件上传本地存储
// */
//        String originalFilename = image.getOriginalFilename();// 文件名
//        int index = originalFilename.lastIndexOf(".");
//        String extraName = originalFilename.substring(index);
//        String newFilename = UUID.randomUUID().toString() + extraName;
//        log.info("新文件名: {}", newFilename);
//        image.transferTo(new File("C:\\Users\\x9868\\Desktop\\资料\\" + newFilename));
//
//        return Result.success();
//    }


    /**
     * 文件上传到阿里云OSS
     */
    @Autowired
    private AliOSSUtils aliOSSUtils;

    @PostMapping("/upload")
    public Result upload(MultipartFile image) throws IOException {
        log.info("上传文件:image={}", image.getOriginalFilename());
        String url = aliOSSUtils.upload(image);
        log.info("上传成功:url={}", url);
        return Result.success(url);
    }
}

