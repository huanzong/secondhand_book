package com.hq.secondhand_book.service.serviceimpl;

import com.hq.secondhand_book.entity.Book;
import com.hq.secondhand_book.entity.BookCategory;
import com.hq.secondhand_book.repository.BookCategoryRepository;
import com.hq.secondhand_book.repository.BookRepository;
import com.hq.secondhand_book.service.BookService;
import com.hq.secondhand_book.util.resp.Response;
import com.hq.secondhand_book.util.resp.ResultResp;
import com.hq.secondhand_book.vo.BookListVo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Resource
    BookRepository bookRepository;
    @Resource
    BookCategoryRepository bookCategoryRepository;

    @Override
    public ResultResp bookList(int page, int size) {
        List<BookListVo> bookListVos=new ArrayList<>();

        if(page<1){
            return Response.dataErr("页码数不能小于1");
        }
        Pageable pageable = PageRequest.of(page-1,size, Sort.Direction.DESC,"cstModify");
        Page<Book> pager = bookRepository.findAllByUsable(1, pageable);

        List<Book> list=pager.getContent();

        if(!list.isEmpty()){
            for(Book book:list){
                BookListVo bookListVo=new BookListVo();
                bookListVo.setBookName(book.getBookName());
                String pic = "picture/book/"+ book.getBookPicture().split("#")[0];
                bookListVo.setBookPicture(pic);
                DecimalFormat df = new DecimalFormat("#.00");
                bookListVo.setBookPrice(df.format(book.getBookPrice()));
                bookListVo.setBookId(book.getId());
                bookListVos.add(bookListVo);

            }
        }
        return Response.ok(bookListVos);
    }

    @Override
    public ResultResp bookListByCategory(int page, String category) {
        List<BookListVo> bookListVos=new ArrayList<>();
        if(page<1){
            return Response.dataErr("页码数不能小于1");
        }
        Pageable pageable = PageRequest.of(page-1,12, Sort.Direction.DESC,"cstModify");
        BookCategory bookCategory = bookCategoryRepository.getByBookCategoryName(category);
        if(bookCategory!=null){
            int bookCategoryId = bookCategory.getId();
            Page<Book> pager = bookRepository.findByBookCategoryIdAndUsable(bookCategoryId,1, pageable);
            List<Book> list=pager.getContent();
            if(!list.isEmpty()){
                for(Book book:list){
                    BookListVo bookListVo=new BookListVo();
                    bookListVo.setBookName(book.getBookName());
                    String pic = "picture/book/"+ book.getBookPicture().split("#")[0];
                    bookListVo.setBookPicture(pic);
                    DecimalFormat df = new DecimalFormat("#.00");
                    bookListVo.setBookPrice(df.format(book.getBookPrice()));
                    bookListVo.setBookId(book.getId());
                    bookListVos.add(bookListVo);
                }
            }
            return  Response.ok(bookListVos);
        }
        return Response.dataErr("找不到资源");
    }

    @Override
    public ResultResp getBookbyId(int bookId) {

        return null;
    }
}
