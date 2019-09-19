package com.test.filter;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.test.pojo.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Serializable;

/**
 * @author LeeShuhang 1142245564@qq.com
 */
public class RequestBodyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        // 读取json
        BufferedReader br = request.getReader();
        String buffer;
        StringBuilder jsonBuilder = new StringBuilder();
        while ((buffer = br.readLine()) != null) {
            jsonBuilder.append(buffer);
        }

        // 将JSONObject对象存进request
        if (jsonBuilder.length() > 0) {
            JSONObject json = JSONObject.parseObject(jsonBuilder.toString());
            request.setAttribute("requestBody", json);
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
