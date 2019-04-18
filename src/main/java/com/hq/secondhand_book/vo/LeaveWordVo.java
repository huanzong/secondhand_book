package com.hq.secondhand_book.vo;

import lombok.Data;

/**
 * 留言内容
 * @auther 黄琦
 * @create 2019 04 18
 */
@Data
public class LeaveWordVo {
    private String userName;//用户名
    private String userPic;//用户头像
    private int leaveId;//留言编号
    private String leaveContent;//留言内容
    private int leaveFatherId;//回复留言ID
    private String leaveDate;//留言时间
}
