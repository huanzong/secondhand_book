package com.hq.secondhand_book.service.serviceimpl;

import com.hq.secondhand_book.entity.Book;
import com.hq.secondhand_book.entity.BookCategory;
import com.hq.secondhand_book.entity.LeaveWord;
import com.hq.secondhand_book.entity.User;
import com.hq.secondhand_book.repository.BookCategoryRepository;
import com.hq.secondhand_book.repository.BookRepository;
import com.hq.secondhand_book.repository.LeaveWordRepository;
import com.hq.secondhand_book.repository.UserRepositiry;
import com.hq.secondhand_book.service.BookService;
import com.hq.secondhand_book.util.Constant;
import com.hq.secondhand_book.util.resp.Response;
import com.hq.secondhand_book.util.resp.ResultResp;
import com.hq.secondhand_book.vo.BookDetails;
import com.hq.secondhand_book.vo.BookListPageVo;
import com.hq.secondhand_book.vo.BookListVo;
import com.hq.secondhand_book.vo.LeaveWordVo;
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
    @Resource
    LeaveWordRepository leaveWordRepository;
    @Resource
    UserRepositiry userRepositiry;

    @Override
    public ResultResp bookList(int page, int size) {
        System.out.println("page:"+page+"size:"+size);
        List<BookListVo> resultList=new ArrayList<>();
        List<Integer> statuses=new ArrayList<Integer>();
        BookListPageVo bookListPageVo=new BookListPageVo();
        if(page<1){
            return Response.dataErr("页码数不能小于1");
        }
        Pageable pageable = PageRequest.of(page-1,size, Sort.Direction.DESC,"cstModify");
        Page<Book> pager = bookRepository.findAllByUsable(1, pageable);
        List<Book> books = bookRepository.findAllByUsable(1);
        List<Book> list=pager.getContent();
        if (!list.isEmpty()){
            for(Book book:list){
                BookListVo bookListVo=new BookListVo();
                bookListVo.setBookName(book.getBookName());
                String pic = "picture/book/"+ book.getBookPicture().split("#")[0];
                bookListVo.setBookPicture(pic);
                DecimalFormat df = new DecimalFormat("#.00");
                bookListVo.setBookPrice(df.format(book.getBookPrice()));
                bookListVo.setBookId(book.getId());
                resultList.add(bookListVo);
            }
        }
        bookListPageVo.setList(resultList);
        bookListPageVo.setRowCount(books.size());
        return Response.ok(bookListPageVo);
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
    public ResultResp getBookDetail(int bookId) {
        BookDetails bookDetails = new BookDetails();
        Book book = bookRepository.findByIdAndUsable(bookId,Constant.USABLE);
        if(book!=null){
            bookDetails.setBookId(book.getId());
            bookDetails.setBookName(book.getBookName());
            String[] pics = book.getBookPicture().split("#");
            for(int i =0 ;i<pics.length;i++){
                pics[i] = "picture/book/"+pics[i];
                System.out.println(pics[i]);
            }
            bookDetails.setBookPicture(pics);
            bookDetails.setBookSynopsis(book.getBookSysnopsis());
            DecimalFormat df = new DecimalFormat("#.00");
            bookDetails.setBookPrice(df.format(book.getBookPrice()));

            //bookDetails.setBookPrice(book.getBookPrice());
            List<LeaveWordVo> leaveWordVoList = new ArrayList<>();
            List<LeaveWord> leaveWords = leaveWordRepository.findByBookIdAndUsable(bookId,Constant.USABLE);
            if(!leaveWords.isEmpty()){
                for(LeaveWord leaveWord:leaveWords){
                    LeaveWordVo leaveWordVo=new LeaveWordVo();
                    leaveWordVo.setLeaveId(leaveWord.getId());
                    User user = userRepositiry.findByIdAndUsable(leaveWord.getId(), Constant.USABLE);
                    if(user!=null){
                        leaveWordVo.setUserName(user.getUserName());
                        String pic = "picture/user/"+ user.getUserPic();
                        leaveWordVo.setUserPic(pic);
                    }
                    leaveWordVo.setLeaveFatherId(leaveWord.getLeaveFatherId());
                    leaveWordVo.setLeaveContent(leaveWord.getLeaveContent());
                    leaveWordVo.setLeaveDate(leaveWord.getCstModify().toString());
                    leaveWordVoList.add(leaveWordVo);
                }
            }
            bookDetails.setLeaveWordList(leaveWordVoList);
        }
        return Response.ok(bookDetails);
    }
}
