package com.hq.secondhand_book.repository;

import com.hq.secondhand_book.entity.BookCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @auther xinye
 * @create 2019 04 03
 */
public interface BookCategoryRepository extends JpaRepository<BookCategory, Integer> {
    List<BookCategory> findByUsable(Integer usable);

    BookCategory getByBookCategoryName(String categoryName);
}
