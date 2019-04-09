package com.hq.secondhand_book.vo;

import lombok.Data;

/**
 * 用户基本信息
 */
@Data
public class UserInfoVo {
    private String userName;   //用户名
    private String userRealName;   //真实姓名
    private String userStuId;   //学号
    private String userBirthday;   //出生年月
    private String userSex;   //用户性别
    private String userTel;   //用户电话
    private String userEmail;      //用户邮箱
}
