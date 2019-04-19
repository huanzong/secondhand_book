package com.hq.secondhand_book.repository;

import com.hq.secondhand_book.entity.Collection;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @auther xinye
 * @create 2019 04 03
 */
public interface CollectionRepository extends JpaRepository<Collection,Integer> {

    Collection getByBookIdAndUserIdAndUsable(int bookId, int userId, int usable);
}
