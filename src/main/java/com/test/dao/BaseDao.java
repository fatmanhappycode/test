package com.test.dao;


import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;

/**
 * @author LeeShuhang 1142245564@qq.com
 */
public abstract class BaseDao<T> {

    private QueryRunner queryRunner;

    private BeanHandler<T> beanHandler;

    private BeanListHandler<T> beanListHandler;

    protected BaseDao(Class<T> clazz) {
        if (clazz == null) {
            throw new IllegalArgumentException("参数不能为空");
        }
        queryRunner = new QueryRunner();
        beanHandler = new BeanHandler<>(clazz);
        beanListHandler = new BeanListHandler<>(clazz);
    }

    /**
     * 查询一条数据，封装为T类型返回
     * @param connection
     * @param sql
     * @param args
     * @return
     */
    protected T selectOne(Connection connection,
                          String sql,
                          Object... args) {
        T result = null;
        try {
            result = queryRunner.query(connection, sql, this.beanHandler, args);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
