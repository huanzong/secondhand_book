package com.hq.secondhand_book.service;

import com.hq.secondhand_book.dto.LeaveWordDto;
import com.hq.secondhand_book.util.resp.ResultResp;

/**
 * @auther xinye
 * @create 2019 04 19
 */
public interface LeaveWordService {
    ResultResp addLeaveWord(LeaveWordDto leaveWordDto);

    ResultResp leaveWordList(int page,int size);

    ResultResp findLeaveWordList(String leaveWordContant, int page,int size);

    ResultResp deleteLeaveWord(int leaveId);
}
