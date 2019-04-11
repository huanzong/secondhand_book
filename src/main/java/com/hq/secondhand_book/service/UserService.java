package com.hq.secondhand_book.service;


import com.hq.secondhand_book.dto.UserDto;
import com.hq.secondhand_book.entity.User;
import com.hq.secondhand_book.vo.LoginVo;
import com.hq.secondhand_book.vo.RegisterVo;
import com.hq.secondhand_book.vo.UserInfoVo;

import java.util.Optional;

/**
 * @auther xinye
 * @create 2019 04 03
 */
public interface UserService {
    boolean isUsernameExist(String username);
    boolean register(RegisterVo registerVo);
    boolean login(LoginVo loginVo);
    User addUser(User user);
    UserInfoVo getUser(String userName);
    void updateUser(UserDto userDto);
}
