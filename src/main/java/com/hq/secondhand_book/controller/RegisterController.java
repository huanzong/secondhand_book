package com.hq.secondhand_book.controller;


import com.hq.secondhand_book.service.UserService;
import com.hq.secondhand_book.util.resp.ResultResp;
import com.hq.secondhand_book.vo.RegisterVo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @auther xinye
 * @create 2019 04 03
 */
@RestController
public class RegisterController {
    @Resource
    UserService userService;

    /**
     * 用户注册
     * @return
     */
    @GetMapping("/register")
    public void addUser(RegisterVo registerVo){

    }

    @GetMapping("/findTel")
    public String findTel(@RequestBody String userTel){
        return "用户名可用";
    }
}
