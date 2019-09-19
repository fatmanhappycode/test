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

    @Override
    public Result<List<Book>> getBookList() {
        Result<List<Book>> result = new Result<>();
        List<Book> bookList = bookDao.getBookInfoList();
        return result.setResult(200,"success",bookList);
    }
}
