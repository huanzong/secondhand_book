package com.hq.secondhand_book.repository;

import com.hq.secondhand_book.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @auther xinye
 * @create 2019 04 03
 */
public interface BookRepository extends JpaRepository<Book,Integer> {
    List<Book> findAllByUsable(Integer usable);
}
