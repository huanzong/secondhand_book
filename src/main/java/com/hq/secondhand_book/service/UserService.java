package com.hq.secondhand_book.service;


import com.hq.secondhand_book.entity.User;
import com.hq.secondhand_book.vo.LoginVo;
import com.hq.secondhand_book.vo.RegisterVo;

/**
 * @auther xinye
 * @create 2019 04 03
 */
public interface UserService {
    boolean isUsernameExist(String username);
    boolean register(RegisterVo registerVo);
    boolean login(LoginVo loginVo);
    User addUser(User user);

}
