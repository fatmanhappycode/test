package com.test.controllor;

import com.alibaba.fastjson.JSONObject;
import com.test.pojo.Result;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;

/**
 * @author LeeShuhang 1142245564@qq.com
 */
public abstract class BaseServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Result result = (Result) req.getAttribute("result");
        PrintWriter out = resp.getWriter();
        if (result != null) {
            out.write(JSONObject.toJSONString(result));
            out.flush();
            out.close();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Result result = (Result) req.getAttribute("result");
        PrintWriter out = resp.getWriter();
        if (result != null) {
            out.write(JSONObject.toJSONString(result));
            out.flush();
            out.close();
        }
    }
}
