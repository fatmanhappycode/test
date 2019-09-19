package com.test.dao;

import com.test.pojo.Book;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @author LeeShuhang 1142245564@qq.com
 */
public class BookDaoTest {

    private BookDao bookDao = DaoFactory.getBookDao();

    private Logger logger = LoggerFactory.getLogger(BookDaoTest.class);

    @Test
    public void testGetById() {
        Book book = bookDao.getById(1);
        logger.info("book:{}", book);
    }

    @Test
    public void testGetList() {
        List<Book> bookList = bookDao.getBookInfoList();
        bookList.forEach(e -> logger.info("book:{}", e));
    }
}
