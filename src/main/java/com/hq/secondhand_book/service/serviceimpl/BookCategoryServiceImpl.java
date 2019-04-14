package com.hq.secondhand_book.service.serviceimpl;

import com.hq.secondhand_book.entity.BookCategory;
import com.hq.secondhand_book.repository.BookCategoryRepository;
import com.hq.secondhand_book.service.BookCategoryService;
import com.hq.secondhand_book.vo.BookCategoryVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookCategoryServiceImpl implements BookCategoryService {
    @Resource
    BookCategoryRepository bookCategoryRepository;

    @Override
    public List<BookCategoryVo> findAll() {
        List<BookCategory> bookCategories = bookCategoryRepository.findByUsable(1);
        ArrayList<BookCategoryVo> bookCategoryVos = new ArrayList<>();
        if(bookCategories!=null){
            for (BookCategory bookCategory : bookCategories) {
                bookCategoryVos.add(new BookCategoryVo(bookCategory.getId(),bookCategory.getBookCategoryName()));
            }
        }
        System.out.println(bookCategoryVos);
        return bookCategoryVos;
    }
}
