package com.hq.secondhand_book.controller;

import com.hq.secondhand_book.service.BookCategoryService;
import com.hq.secondhand_book.util.resp.Response;
import com.hq.secondhand_book.util.resp.ResultResp;
import com.hq.secondhand_book.vo.BookCategoryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookCategoryController {
    @Autowired
    BookCategoryService bookCategoryService;
    @GetMapping("/findbookcategory")
    public ResultResp findAll(){
        List<BookCategoryVo> bookCategoryVos = bookCategoryService.findAll();
        System.out.println(bookCategoryVos);
        return Response.ok(bookCategoryVos);
    }
}
