package com.test.pojo;

import javax.servlet.http.HttpServlet;
import java.util.Arrays;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * @author LeeShuhang 1142245564@qq.com
 */
public class ServletProxyInfo {

    private String name;

    private String[] urlMapping;

    private HttpServlet servlet;

    public ServletProxyInfo() {
    }

    public ServletProxyInfo(String name, String[] urlMapping, HttpServlet servlet) {
        this.name = name;
        this.urlMapping = urlMapping;
        this.servlet = servlet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getUrlMapping() {
        return urlMapping;
    }

    public void setUrlMapping(String[] urlMapping) {
        this.urlMapping = urlMapping;
    }

    public HttpServlet getServlet() {
        return servlet;
    }

    public void setServlet(HttpServlet servlet) {
        this.servlet = servlet;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", ServletProxyInfo.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("urlMapping=" + Arrays.toString(urlMapping))
                .add("servlet=" + servlet)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ServletProxyInfo servletProxyInfo = (ServletProxyInfo) o;
        return name.equals(servletProxyInfo.name) &&
                Arrays.equals(urlMapping, servletProxyInfo.urlMapping) &&
                servlet.equals(servletProxyInfo.servlet);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name, servlet);
        result = 31 * result + Arrays.hashCode(urlMapping);
        return result;
    }
}
