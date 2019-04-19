package com.hq.secondhand_book.controller;

import com.hq.secondhand_book.dto.LeaveWordDto;
import com.hq.secondhand_book.service.LeaveWordService;
import com.hq.secondhand_book.util.resp.Response;
import com.hq.secondhand_book.util.resp.ResultResp;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @auther xinye
 * @create 2019 04 19
 */
@RestController
public class LeaveWordController {
    @Resource
    LeaveWordService leaveWordService;

    /**
     * 用户跟针对图书发布留言
     * @param leaveWordDto
     * @return
     */
    @PostMapping("/addleaveword")
    public ResultResp addLeaveWord(@RequestBody LeaveWordDto leaveWordDto){
        System.out.println(leaveWordDto);
        if(leaveWordDto.getUserName().isEmpty()){
            Response.dataErr("请登录");
        }if(leaveWordDto.getBookId() == 0){
            Response.dataErr("图书不存在");
        }
        return leaveWordService.addLeaveWord(leaveWordDto);
    }
}
