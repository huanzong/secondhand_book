package com.hq.secondhand_book.repository;

import com.hq.secondhand_book.entity.PlaceTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @auther xinye
 * @create 2019 04 03
 */
public interface PlaceTransactionRepository extends JpaRepository<PlaceTransaction, Integer> {

    List<PlaceTransaction> findAll();

}
