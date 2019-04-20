package com.hq.secondhand_book.repository;

import com.hq.secondhand_book.entity.ReceivingAddress;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @auther xinye
 * @create 2019 04 03
 */
public interface ReceivingAddressRepository extends JpaRepository<ReceivingAddress, Integer> {

    List<ReceivingAddress> getByUserIdAndUsable(int userId, int usable);

    ReceivingAddress getById(int userId);
}
