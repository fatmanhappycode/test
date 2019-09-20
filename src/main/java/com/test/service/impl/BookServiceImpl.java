package com.test.service.impl;

import com.test.dao.BookDao;
import com.test.dao.DaoFactory;
import com.test.pojo.Book;
import com.test.pojo.Result;
import com.test.service.BookService;

import java.io.Serializable;
import java.util.List;

/**
 * @author LeeShuhang 1142245564@qq.com
 */
public class BookServiceImpl implements BookService {

    private BookDao bookDao = DaoFactory.getBookDao();

    private static final BookServiceImpl BOOK_SERVICE;

    static {
        BOOK_SERVICE = new BookServiceImpl();
    }

    private BookServiceImpl() {
    }

    @Override
    public Result<List<Book>> getBookList() {
        Result<List<Book>> result = new Result<>();
        List<Book> bookList = bookDao.getBookInfoList();
        return result.setResult(200, "success", bookList);
    }

    public static BookServiceImpl getInstance(){
        return BOOK_SERVICE;
    }
}
