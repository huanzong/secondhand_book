package com.hq.secondhand_book.service;

import com.hq.secondhand_book.dto.LeaveWordDto;
import com.hq.secondhand_book.util.resp.ResultResp;

/**
 * @auther xinye
 * @create 2019 04 19
 */
public interface LeaveWordService {
    ResultResp addLeaveWord(LeaveWordDto leaveWordDto);
}
