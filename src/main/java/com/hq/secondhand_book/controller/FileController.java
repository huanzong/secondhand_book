package com.hq.secondhand_book.controller;

import com.hq.secondhand_book.service.FileService;
import com.hq.secondhand_book.service.UserService;
import com.hq.secondhand_book.util.resp.Response;
import com.hq.secondhand_book.util.resp.ResultResp;
import com.hq.secondhand_book.vo.UserInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


/**
 * @auther xinye
 * @create 2019 04 09
 */
@RestController
public class FileController {

    @Autowired
    UserService userService;
    @Autowired
    FileService fileService;

    @PostMapping(value = "/singlefile")
    public ResultResp headImg(@RequestParam(value="file",required=false) MultipartFile file, String userName) throws Exception {
        fileService.singleFile(file,userName);
        return Response.ok();
    }

    @GetMapping("/test")
    public ResultResp test(){
        UserInfoVo user = userService.getUser("张三");
        return Response.ok(user);
    }
}