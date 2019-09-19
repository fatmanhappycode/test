package com.test;

import com.test.util.JdbcUtil;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.sql.Connection;

/**
 * @author LeeShuhang 1142245564@qq.com
 */

public class JdbcUtilTest {

    private Logger logger = LoggerFactory.getLogger(JdbcUtilTest.class);

    @Test
    public void testGetConnection() {
        try (Connection conn = JdbcUtil.getConnection()){
            logger.info("connection.class:{}", conn.getClass());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
