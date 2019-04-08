package com.hq.secondhand_book.controller;


import com.hq.secondhand_book.service.UserService;
import com.hq.secondhand_book.vo.RegisterVo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping("/findName")
    public String findNmae(@RequestBody String userName){
        System.out.println(userName);
        if(userService.isUsernameExist(userName)){
            return "用户名已存在";
        }
        return "用户名可用";
    }

    @GetMapping("/findTel")
    public String findTel(@RequestBody String userTel){
        return "用户名可用";
    }
}
