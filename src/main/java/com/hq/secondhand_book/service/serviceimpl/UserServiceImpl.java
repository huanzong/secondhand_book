package com.hq.secondhand_book.service.serviceimpl;

import com.hq.secondhand_book.dto.UserDto;
import com.hq.secondhand_book.entity.User;
import com.hq.secondhand_book.repository.UserRepositiry;
import com.hq.secondhand_book.service.UserService;
import com.hq.secondhand_book.vo.LoginVo;
import com.hq.secondhand_book.vo.RegisterVo;
import com.hq.secondhand_book.vo.UserInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * @auther xinye
 * @create 2019 04 03
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
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

    /**
     *根据用户名查找用户
     */
    @Override
    public UserInfoVo getUser(String userName) {
        UserInfoVo userInfoVo = new UserInfoVo();
        Optional<User> optionalUser = userRepositiry.getByUserNameAndUsable(userName,1);
        if(optionalUser.isPresent()){
            User user = optionalUser.get();
            String url = "../picture/user/"+user.getUserPic();
            userInfoVo = new UserInfoVo(user.getUserName(),user.getUserRelName(),user.getUserStuId(),user.getUserBirthday(),
                    user.getUserSex(),user.getUserTel(),user.getUserEmail(),url);
        }
        return userInfoVo ;
    }

    /**
     * 更新用户
     * @param userDto
     */
    @Override
    public void updateUser(UserDto userDto) {
        Optional<User> optionalUser = userRepositiry.getByUserNameAndUsable(userDto.getUserName(),1);
        if(optionalUser.isPresent()){
            User user =optionalUser.get();
            user.setUserRelName(userDto.getUserRealName());
            user.setUserBirthday(userDto.getUserBirthday());
            user.setUserSex(userDto.getUserSex());
            user.setUserTel(userDto.getUserTel());
            user.setUserEmail(userDto.getUserEmail());
            userRepositiry.saveAndFlush(user);
        }
    }
}
