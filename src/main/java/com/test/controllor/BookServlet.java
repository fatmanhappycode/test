package com.test.controllor;

import com.test.pojo.Book;
import com.test.pojo.Result;
import com.test.service.BookService;
import com.test.service.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;

/**
 * @author LeeShuhang 1142245564@qq.com
 */
@WebServlet(urlPatterns = {"/book"})
public class BookServlet extends BaseServlet {

    private BookService bookService = ServiceFactory.getBookService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Result<List<Book>> result = bookService.getBookList();
        req.setAttribute("result", result);
        super.doGet(req, resp);
    }
}
