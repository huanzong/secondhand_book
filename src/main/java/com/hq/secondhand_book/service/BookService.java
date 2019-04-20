package com.hq.secondhand_book.service;

import com.hq.secondhand_book.util.resp.ResultResp;

public interface BookService {
    ResultResp bookList(int page, int size);

    ResultResp bookListByCategory(int page,String category);

    ResultResp getBookDetail(int bookId,String userName);

    ResultResp getbookOrder(int bookId);
}
