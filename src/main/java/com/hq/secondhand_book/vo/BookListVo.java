package com.hq.secondhand_book.vo;

import lombok.Data;

@Data
public class BookListVo {
    private String bookName;//图书名称
    private String bookPicture;//图书图片，主图片，数据库中第一张图
    private String bookPrice;// 图书价格
    private String userName; //图书卖家名
    private String userPicture; //卖家头像
}
