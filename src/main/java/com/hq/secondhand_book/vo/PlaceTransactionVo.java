package com.hq.secondhand_book.vo;

import lombok.Data;

@Data
public class PlaceTransactionVo {
    private int placeTransactionId;//交易地点编号
    private int placeFatherId;//交易地点父编号
    private String placeName;//交易地点名
    private int placeLevel;//交易地点级别
}
