package com.hq.secondhand_book.service;

import com.hq.secondhand_book.util.resp.ResultResp;

/**
 * @auther xinye
 * @create 2019 04 20
 */
public interface OrderService {
    //ResultResp addOrder(int bookId,int addressId,String userName,String remark);
    ResultResp addOrder(int bookId,int addressId,String userName);
}
