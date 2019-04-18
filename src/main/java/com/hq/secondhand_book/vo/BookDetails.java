package com.hq.secondhand_book.vo;

import lombok.Data;

import java.util.List;

/**
 * @// TODO: 2019/4/17
 * 图书详情
 */
@Data
public class BookDetails {
    private int bookId; //图书编号
    private String bookName;//图书名称
    private String bookSynopsis;    //图书简介
    private String[] bookPicture;//图书图片，主图片，数据库中第一张图
    private String bookPrice;// 图书价格
    private List<LeaveWordVo> leaveWordList;//留言

    public BookDetails() {
    }

    public BookDetails(int bookId, String bookName, String bookSynopsis, String[] bookPicture, String bookPrice, List<LeaveWordVo> leaveWordList) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookSynopsis = bookSynopsis;
        this.bookPicture = bookPicture;
        this.bookPrice = bookPrice;
        this.leaveWordList = leaveWordList;
    }
}
