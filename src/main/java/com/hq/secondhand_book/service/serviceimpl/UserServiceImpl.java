package com.hq.secondhand_book.service.serviceimpl;

import com.hq.secondhand_book.entity.User;
import com.hq.secondhand_book.repository.UserRepositiry;
import com.hq.secondhand_book.service.UserService;
import com.hq.secondhand_book.vo.LoginVo;
import com.hq.secondhand_book.vo.RegisterVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @auther xinye
 * @create 2019 04 03
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepositiry userRepositiry;
    @Override
    public boolean isUsernameExist(String username) {
        System.out.println("123"+username+"123");
        User user = userRepositiry.getByUserName(username);
        if( user != null){
            return true;
        }
        return false;
    }

    @Override
    public boolean register(RegisterVo registerVo) {
        return false;
    }

    //用户名密码正确且用户状态正常可登录
    @Override
    public boolean login(LoginVo loginVo) {
        User user = userRepositiry.getByUserNameAndUserPwdAndUsable(loginVo.getUserName(),loginVo.getUserPwd(),1);
        if(user != null){
            return true;
        }
        return false;
    }

    @Override
    public User addUser(User user) {
        return userRepositiry.saveAndFlush(user);
    }
}
