package com.hq.secondhand_book.service.serviceimpl;

import com.hq.secondhand_book.entity.*;
import com.hq.secondhand_book.repository.*;
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
import java.text.SimpleDateFormat;
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
    @Resource
    CollectionRepository collectionRepository;

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

    /**
     * 分类查询图书
     * @param page
     * @param category
     * @return
     */
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


    /**
     * 详情
     * @param bookId
     * @param userName
     * @return
     */
    @Override
    public ResultResp getBookDetail(int bookId, String userName) {
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

            //留言
            //bookDetails.setBookPrice(book.getBookPrice());
            List<LeaveWordVo> leaveWordVoList = new ArrayList<>();
            List<LeaveWord> leaveWords = leaveWordRepository.findByBookIdOrderByCstModifyDesc(bookId);
            if(!leaveWords.isEmpty()){
                for(LeaveWord leaveWord:leaveWords){
                    LeaveWordVo leaveWordVo=new LeaveWordVo();
                    leaveWordVo.setLeaveId(leaveWord.getId());
                    User user = userRepositiry.findByIdAndUsable(leaveWord.getUserId(), Constant.USABLE);
                    if(user!=null){
                        leaveWordVo.setUserName(user.getUserName());
                        String pic = "picture/user/"+ user.getUserPic();
                        leaveWordVo.setUserPic(pic);
                    }
                    leaveWordVo.setLeaveFatherId(leaveWord.getLeaveFatherId());
                    leaveWordVo.setLeaveContent(leaveWord.getLeaveContent());
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
                    leaveWordVo.setLeaveDate(sdf.format(leaveWord.getCstModify()));
                    leaveWordVoList.add(leaveWordVo);
                }
            }
            bookDetails.setLeaveWordList(leaveWordVoList);
            //TODO 收藏功能
            int isCollection = 0;
            if(!userName.isEmpty()){
                User user = userRepositiry.findByUserName(userName);
                Collection collection = collectionRepository.getByBookIdAndUserIdAndUsable(bookId,user.getId(),Constant.USABLE);
                if(collection!=null){
                    isCollection = 1;
                }
            }
            bookDetails.setIsCollection(isCollection);
        }
        return Response.ok(bookDetails);
    }

    @Override
    public ResultResp getbookOrder(int bookId) {
        Book book = bookRepository.findByIdAndUsable(bookId,Constant.USABLE);
        BookListVo vo = new BookListVo();
        if( book!=null){
            vo.setBookId(bookId);
            vo.setBookName(book.getBookName());
            String pic = "picture/book/"+ book.getBookPicture().split("#")[0];
            vo.setBookPicture(pic);
            DecimalFormat df = new DecimalFormat("#.00");
            vo.setBookPrice(df.format(book.getBookPrice()));
            return Response.ok(vo);
        }
        return Response.dataErr("图书已失效");

    }
}
