package com.hq.secondhand_book.repository;

import com.hq.secondhand_book.entity.LeaveWord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @auther xinye
 * @create 2019 04 03
 */
public interface LeaveWordRepository extends JpaRepository<LeaveWord, Integer> {
    List<LeaveWord> findByBookIdOrderByCstModifyDesc(int bookId);
}
