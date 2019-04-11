package com.hq.secondhand_book.repository;

import com.hq.secondhand_book.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @auther xinye
 * @create 2019 04 03
 */
@Repository
public interface UserRepositiry extends JpaRepository<User,Integer>  {
    User getByUserNameAndUserPwdAndUsable(String userName, String userPwd, Integer usable);

    User getByUserName(String userName);

    Optional<User> getByUserNameAndUsable(String userName, Integer usable);

    List<User> findAll();

}
