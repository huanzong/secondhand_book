package com.hq.secondhand_book.controller;

import com.hq.secondhand_book.service.BookService;
import com.hq.secondhand_book.util.resp.Response;
import com.hq.secondhand_book.util.resp.ResultResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
    @Autowired
    BookService bookService;

    @GetMapping("/booklist")
    public ResultResp bookList(@RequestParam(required = false, defaultValue = "1") int page,
                               @RequestParam(required = false, defaultValue = "8") int size){
        return bookService.bookList(page,size);
    }

    /**
     *分类查找图书
     */
    @GetMapping("/bookcategory")
    public ResultResp booListBycategory(@RequestParam int page,
            @RequestParam String category){
        return bookService.bookListByCategory(page,category);
    }

//    @GetMapping("/booklist/{bookId}")
//    public ResultResp booListBycategory(@RequestParam int bookId){
//        return bookService.bookListByCategory(page,category);
//    }
}
