package com.hq.secondhand_book.controller;

import com.hq.secondhand_book.service.ReceiveAdressService;
import com.hq.secondhand_book.util.resp.ResultResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class ReceiveAdressController {
    @Autowired
    ReceiveAdressService receiveAdressService;

    /**
     * 用户的收货地址
     * @param userName
     * @return
     */
    @GetMapping("/getreceiveadress")
    public ResultResp getReceiveAdress(String userName){
        return receiveAdressService.getRececiveAdress(userName);
    }
}
