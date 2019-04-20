package com.hq.secondhand_book.controller;

import com.hq.secondhand_book.service.OrderService;
import com.hq.secondhand_book.util.resp.ResultResp;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @auther xinye
 * @create 2019 04 20
 */
@RestController
public class OrderController {
    @Resource
    OrderService orderService;

    @PostMapping("/addorder")
    public ResultResp addOrder(@RequestParam String userName,
                               @RequestParam int bookId,
                               @RequestParam int addressId){
        System.out.println(1234564545);
        return orderService.addOrder(bookId,addressId,userName);
    }
}
