package com.hq.secondhand_book.vo.book;

import lombok.Data;

import java.util.List;

/**
 * @auther 黄琦
 * @create 2019 04 18
 */
@Data
public class BookListPageVo {
    private List<BookListVo> list;
    private int rowCount;
}
