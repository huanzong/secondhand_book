package com.hq.secondhand_book.controller;

import com.hq.secondhand_book.service.PlaceTransactionService;
import com.hq.secondhand_book.util.resp.ResultResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class PlaceTransactionController {
    @Autowired
    PlaceTransactionService placeTransactionService;

    /**
     * 交易地点列表
     * @return
     */
    @GetMapping("/placelist")
    public ResultResp getPlace(){
        return placeTransactionService.getPlace();
    }
}
