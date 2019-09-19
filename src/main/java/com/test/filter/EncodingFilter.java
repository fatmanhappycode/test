package com.test.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;

/**
 * @author LeeShuhang 1142245564@qq.com
 */
public class EncodingFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 设置请求编码为UTF-8
        servletRequest.setCharacterEncoding("UTF-8");
        // 设置响应编码为UTF-8
        ((HttpServletResponse) servletResponse).setContentType("application/json;charset=UTF-8");
        ((HttpServletResponse) servletResponse).setCharacterEncoding("UTF-8");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
