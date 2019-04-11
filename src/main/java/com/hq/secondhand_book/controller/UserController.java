package com.hq.secondhand_book.controller;

import com.hq.secondhand_book.dto.UserDto;
import com.hq.secondhand_book.service.UserService;
import com.hq.secondhand_book.util.resp.Response;
import com.hq.secondhand_book.util.resp.ResultResp;
import com.hq.secondhand_book.vo.UserInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther xinye
 * @create 2019 04 03
 */
@RestController
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/userinfo")
    public ResultResp getUser(String userName){
        UserInfoVo vo = userService.getUser(userName);
        return Response.ok(vo);
    }

    @PostMapping("/updateuser")
    public ResultResp updateUser(UserDto userDto){
        return Response.ok();
    }
}
