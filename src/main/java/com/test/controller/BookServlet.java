package com.test.controller;

import com.test.annotation.ServletProxyTarget;
import com.test.pojo.Book;
import com.test.pojo.Result;
import com.test.service.BookService;
import com.test.factory.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author LeeShuhang 1142245564@qq.com
 */
@ServletProxyTarget(name = "bookServlet", urlPatterns = {"/book"})
public class BookServlet extends HttpServlet {

    private static final long serialVersionUID = -8104002398398851034L;

    private BookService bookService = ServiceFactory.getBookService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Result<List<Book>> result = bookService.getBookList();
        req.setAttribute("result", result);
    }
}
