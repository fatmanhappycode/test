package com.test.dao;

import com.test.pojo.Book;

import java.util.List;

/**
 * @author LeeShuhang 1142245564@qq.com
 */
public interface BookDao {

    /**
     * 根据id获取图书信息
     * @param id
     * @return
     */
    Book getById(Integer id);

    /**
     * 获取图书列表
     * @return
     */
    List<Book> getBookInfoList();
}
