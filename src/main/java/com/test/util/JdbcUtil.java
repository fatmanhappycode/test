package com.test.util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * 用于与数据库建立连接
 * @author 肥宅快乐码
 * @date 2018/10/11 - 22:47
 */
public class JdbcUtil {
	
	/**
	 * 链接数据库
	 * @return
	 */
    public Connection getCon() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url="jdbc:mysql://localhost:8080/cashsale?useUnicode=true&characterEncoding=utf-8";
            String user="root";
            String password="2230609";

            Connection conn = DriverManager.getConnection(url,user,password);
            return conn;
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
