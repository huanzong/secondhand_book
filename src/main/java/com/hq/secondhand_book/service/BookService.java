package com.hq.secondhand_book.service;

import com.hq.secondhand_book.util.resp.ResultResp;
import com.hq.secondhand_book.vo.BookListVo;

import java.util.List;

public interface BookService {
    ResultResp bookList(int page, int size);

    ResultResp bookListByCategory(int page,String category);

    ResultResp getBookbyId(int bookId);
}
