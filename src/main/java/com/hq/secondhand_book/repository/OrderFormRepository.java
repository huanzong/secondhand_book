package com.hq.secondhand_book.repository;

import com.hq.secondhand_book.entity.OrderForm;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @auther xinye
 * @create 2019 04 03
 */
public interface OrderFormRepository extends JpaRepository<OrderForm, Integer> {
}
