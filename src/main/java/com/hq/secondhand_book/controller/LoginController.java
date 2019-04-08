package com.hq.secondhand_book.controller;

import com.hq.secondhand_book.service.UserService;
import com.hq.secondhand_book.vo.LoginVo;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @auther 黄琦
 * @create 2019 04 03
 */
@RestController
public class LoginController {
    @Resource
    UserService userService;
    /**
     * 用户登录
     */
    @PostMapping("/login")
    public String login(@RequestBody @Validated LoginVo loginVo){
        if(userService.login(loginVo)){
            return "登录成功";
        }
        return "用户名或密码错误";
    }
}
