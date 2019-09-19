package com.test.service;

import com.test.pojo.Book;
import com.test.pojo.Result;

import java.io.Serializable;
import java.util.List;

/**
 * @author LeeShuhang 1142245564@qq.com
 */
public interface BookService {

    Result<List<Book>> getBookList();
}
