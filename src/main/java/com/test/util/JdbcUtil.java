package com.test.util;

import com.alibaba.druid.filter.Filter;
import com.alibaba.druid.filter.logging.Slf4jLogFilter;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceStatLoggerImpl;
import com.alibaba.druid.support.jconsole.DruidPlugin;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * 用于与数据库建立连接
 *
 * @author 肥宅快乐码
 * @date 2018/10/11 - 22:47
 */
public class JdbcUtil {

    private static DruidDataSource dataSource;

    static {
        initDataSource();
    }

    /**
     * 初始化Druid数据库连接池
     */
    private static void initDataSource() {
        Properties props = new Properties();
        try {
            InputStream in = JdbcUtil.class.getClassLoader().getResourceAsStream("jdbc.properties");
            if (in == null) {
                throw new IOException("配置文件读取失败");
            }
            props.load(in);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Druid连接池配置文件加载失败！！！");
        }
        dataSource = new DruidDataSource();
        // 设置dataSource的属性
        dataSource.setUrl(props.getProperty("jdbc.url"));
        dataSource.setDriverClassName(props.getProperty("jdbc.driverClassName"));
        dataSource.setUsername(props.getProperty("jdbc.username"));
        dataSource.setPassword(props.getProperty("jdbc.password"));

        dataSource.setInitialSize(Integer.parseInt(props.getProperty("druid.initialSize")));
        dataSource.setMinIdle(Integer.parseInt(props.getProperty("druid.minIdle")));
        dataSource.setMaxActive(Integer.parseInt(props.getProperty("druid.maxActive")));
        dataSource.setMaxWait(Integer.parseInt(props.getProperty("druid.maxWait")));

        dataSource.setTimeBetweenConnectErrorMillis(Long.parseLong(props.getProperty("druid.timeBetweenEvictionRunsMillis")));
        dataSource.setMinEvictableIdleTimeMillis(Long.parseLong(props.getProperty("druid.minEvictableIdleTimeMillis")));
        dataSource.setValidationQuery(props.getProperty("druid.validationQuery"));
        dataSource.setTestWhileIdle(Boolean.parseBoolean(props.getProperty("druid.testWhileIdle")));
        dataSource.setTestOnBorrow(Boolean.parseBoolean(props.getProperty("druid.testOnBorrow")));
        dataSource.setTestOnReturn(Boolean.parseBoolean(props.getProperty("druid.testOnReturn")));
        dataSource.setPoolPreparedStatements(Boolean.parseBoolean(props.getProperty("druid.poolPreparedStatements")));
        dataSource.setMaxPoolPreparedStatementPerConnectionSize(Integer.parseInt(props.getProperty("druid.maxPoolPrepareStatementPerConnectionSize")));
        dataSource.setConnectionProperties(props.getProperty("druid.connectionProperties"));
        /*Slf4jLogFilter filter = new Slf4jLogFilter();
        List<Filter> filterList = new ArrayList<>(1);

        filter.setStatementExecutableSqlLogEnable(true);
        filter.setStatementLogEnabled(true);
        filter.setStatementLogErrorEnabled(true);
        filterList.add(filter);

        dataSource.setProxyFilters(filterList);*/

        try {
            dataSource.addFilters("slf4j");
            dataSource.init();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Druid连接池初始化失败！！！");
        }
    }

    /**
     * 获取数据库连接
     *
     * @return
     */
    public static Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 关闭数据库连接
     */
    public static void closeConnection(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
