package com.hq.secondhand_book.vo;

import lombok.Data;

@Data
public class ReceiveAddressVo {
    private String receiverName;//收货人姓名
    private String placeName;//交易地点名
    private String receiverTel;//收货人电话
}
