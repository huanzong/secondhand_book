package com.hq.secondhand_book.service.serviceimpl;

import com.hq.secondhand_book.entity.Book;
import com.hq.secondhand_book.entity.OrderForm;
import com.hq.secondhand_book.entity.ReceivingAddress;
import com.hq.secondhand_book.entity.User;
import com.hq.secondhand_book.repository.BookRepository;
import com.hq.secondhand_book.repository.OrderFormRepository;
import com.hq.secondhand_book.repository.UserRepositiry;
import com.hq.secondhand_book.service.OrderService;
import com.hq.secondhand_book.util.Constant;
import com.hq.secondhand_book.util.resp.Response;
import com.hq.secondhand_book.util.resp.ResultResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @auther xinye
 * @create 2019 04 20
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    UserRepositiry userRepositiry;
    @Autowired
    BookRepository bookRepository;
    @Autowired
    OrderFormRepository orderFormRepository;
    @Override
    public ResultResp addOrder(int bookId, int addressId, String userName) {
        OrderForm orderForm = new OrderForm();
        User user =  userRepositiry.findByUserName(userName);
        if(user != null){
            orderForm.setUserId(user.getId());
        }else {
            Response.dataErr("用户不存在");
        }
        Book book = bookRepository.findByIdAndUsable(bookId, Constant.USABLE);
        if(book!=null){
            orderForm.setBookId(bookId);
        }
        ReceivingAddress address = new ReceivingAddress();
        if(address!= null){
            orderForm.setReceiverId(addressId);
        }
        orderForm.setOrderRemark(new String());
        orderForm.setOrderState(Constant.DELIVERY);
        orderForm.setUsable(Constant.USABLE);
        orderForm.setCstCreate(new Date());
        orderForm.setCstModify(new Date());
        orderFormRepository.saveAndFlush(orderForm);
        return Response.ok();
    }
}
