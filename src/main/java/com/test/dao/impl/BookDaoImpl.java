package com.test.dao.impl;

import com.test.dao.BaseDao;
import com.test.dao.BookDao;
import com.test.pojo.Book;
import com.test.util.JdbcUtil;

import java.io.Serializable;
import java.sql.Connection;
import java.util.List;

/**
 * @author LeeShuhang 1142245564@qq.com
 */
public class BookDaoImpl extends BaseDao<Book> implements BookDao {

    private static final BookDaoImpl BOOK_DAO;



    static {
        BOOK_DAO = new BookDaoImpl();
    }

    private static final String GET_BY_ID_SQL = "SELECT `id`,`name`,`price`,`author`,`isbn`" +
            "FROM `book` " +
            "WHERE `id` = ? " +
            "LIMIT 1;";

    private static final String GET_LIST = "SELECT `id`,`name`,`price`,`author`,`isbn`" +
            "FROM `book`";

    private BookDaoImpl() {
        super(Book.class);
    }

    @Override
    public Book getById(Integer id) {
        Connection connection = JdbcUtil.getConnection();
        Book book = super.selectOne(connection, GET_BY_ID_SQL, id);
        JdbcUtil.closeConnection(connection);
        return book;
    }

    @Override
    public List<Book> getBookInfoList() {
        Connection connection = JdbcUtil.getConnection();
        List<Book> bookList = super.selectList(connection, GET_LIST);
        JdbcUtil.closeConnection(connection);
        return bookList;
    }

    public static BookDaoImpl getInstance(){
        return BookDaoImpl.BOOK_DAO;
    }
}
