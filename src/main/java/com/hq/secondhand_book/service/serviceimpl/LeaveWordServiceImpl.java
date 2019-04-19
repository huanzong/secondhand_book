package com.hq.secondhand_book.service.serviceimpl;

import com.hq.secondhand_book.dto.LeaveWordDto;
import com.hq.secondhand_book.entity.Book;
import com.hq.secondhand_book.entity.LeaveWord;
import com.hq.secondhand_book.entity.User;
import com.hq.secondhand_book.repository.BookRepository;
import com.hq.secondhand_book.repository.LeaveWordRepository;
import com.hq.secondhand_book.repository.UserRepositiry;
import com.hq.secondhand_book.service.LeaveWordService;
import com.hq.secondhand_book.util.Constant;
import com.hq.secondhand_book.util.resp.Response;
import com.hq.secondhand_book.util.resp.ResultResp;
import com.hq.secondhand_book.vo.LeaveWordVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @auther xinye
 * @create 2019 04 19
 */
@Service
public class LeaveWordServiceImpl implements LeaveWordService {
    @Autowired
    UserRepositiry userRepositiry;
    @Autowired
    BookRepository bookRepository;
    @Autowired
    LeaveWordRepository leaveWordRepository;

    /**
     * 发布留言
     * @param leaveWordDto
     * @return
     */
    @Override
    public ResultResp addLeaveWord(LeaveWordDto leaveWordDto) {
        LeaveWord leaveWord = new LeaveWord();
        User user = userRepositiry.findByUserName(leaveWordDto.getUserName());
        if(user!=null){
            leaveWord.setUserId(user.getId());
        }else {
            Response.dataErr("用户不存在");
        }
        Book book = bookRepository.findByIdAndUsable(leaveWordDto.getBookId(), Constant.USABLE);
        if(book!=null){
            leaveWord.setBookId(book.getId());
        }else {
            Response.dataErr("图书不存在");
        }
        leaveWord.setLeaveContent(leaveWordDto.getLeaveContent());
        leaveWord.setLeaveFatherId(0);
        leaveWord.setUsable(Constant.USABLE);
        leaveWord.setCstCreate(new Date());
        leaveWord.setCstModify(new Date());
        leaveWordRepository.saveAndFlush(leaveWord);
        /**
         * 查询该图书的所有留言
         */
        List<LeaveWordVo> leaveWordVoList = new ArrayList<>();
        List<LeaveWord> leaveWords = leaveWordRepository.findByBookIdOrderByCstModifyDesc(book.getId());
        if(!leaveWords.isEmpty()){
            for(LeaveWord word:leaveWords){
                LeaveWordVo leaveWordVo=new LeaveWordVo();
                leaveWordVo.setLeaveId(word.getId());
                System.out.println(word.getUserId());
                User lwUser = userRepositiry.findByIdAndUsable(word.getUserId(),Constant.USABLE);
                if(lwUser!=null){
                    leaveWordVo.setUserName(lwUser.getUserName());
                    String pic = "picture/user/"+ lwUser.getUserPic();
                    leaveWordVo.setUserPic(pic);
                }
                leaveWordVo.setLeaveFatherId(word.getLeaveFatherId());
                leaveWordVo.setLeaveContent(word.getLeaveContent());
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
                leaveWordVo.setLeaveDate(sdf.format(word.getCstModify()));
                leaveWordVoList.add(leaveWordVo);
            }
        }
        return Response.ok(leaveWordVoList);
    }
}
