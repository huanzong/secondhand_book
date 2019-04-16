package com.hq.secondhand_book.repository;

import com.hq.secondhand_book.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @auther xinye
 * @create 2019 04 03
 */
public interface BookRepository extends JpaRepository<Book,Integer> {
    Page<Book> findAllByUsable(int usable, Pageable pageable);
    //List<Book> findAllByUsable(Integer usable);
    Book findByUserIdAndBookNameAndBookSysnopsisAndBookPriceAndBookCategoryId(int userId,String bookName,String bookSysnopsis,Double bookPrice,int bookCategory);

    Page<Book> findByBookCategoryIdAndUsable(int categoryId,int usable, Pageable pageable);
}
