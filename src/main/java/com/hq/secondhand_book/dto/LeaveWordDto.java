package com.hq.secondhand_book.dto;

import lombok.Data;

/**
 * 买家用户针对图书留言
 * @auther 黄琦
 * @create 2019 04 19
 */

@Data
public class LeaveWordDto {
    private String userName;//用户名
    private String leaveContent;//留言内容
    private int bookId; //图书编号
}
