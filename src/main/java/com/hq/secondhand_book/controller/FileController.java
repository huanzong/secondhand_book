package com.hq.secondhand_book.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @auther xinye
 * @create 2019 04 09
 */
@RestController
public class FileController {
    @PostMapping(value = "/singlefile")
    public Object headImg(@RequestParam(value="file",required=false) MultipartFile file, HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            String name = file.getOriginalFilename();//上传文件的真实名称
            String suffixName = name.substring(name.lastIndexOf(".")+1);//获取后缀名
            String fileName = UUID.randomUUID()+"."+suffixName;
            //图片的存储位置
            String filePath = "E://hq_gitresp//used_book//src//main//resources//static//picture//";
            File dest = new File(filePath + fileName);
            if (!dest.getParentFile().exists()) {
                dest.getParentFile().mkdirs();
            }
            try {
                file.transferTo(dest);
            } catch (IOException e) {
                e.printStackTrace();
            }
            String image = filePath+fileName;
            System.out.println(image);
            map.put("code", 0);
            map.put("message", "上传成功");
            map.put("data", image);
        } catch (Exception e) {
            map.put("code", 1);
            e.printStackTrace();
        }
        System.out.println(map);
        return map;
    }
}