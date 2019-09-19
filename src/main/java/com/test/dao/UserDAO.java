package com.test.dao;

import com.cashsale.util.CommonUtils;
import com.cashsale.util.KeytoolUtil;
import com.cashsale.util.RSAUtil;

import java.security.interfaces.RSAPrivateKey;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author 肥宅快乐码
 * @date 2018/10/28 - 16:23
 */
public class UserDAO {

    Connection conn = new com.test.util.JdbcUtil().getCon();
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    public String isLogin(String userName, String password, String keystoreUrl) {
        try {
            String pass = "";
            // 查询是否存在账号密码在all_user
            pstmt = conn.prepareStatement("SELECT pass_word FROM user WHERE user_name=?");
            pstmt.setString(1, userName);
            rs = pstmt.executeQuery();
            if(rs.next()){
                RSAPrivateKey key = new KeytoolUtil().getPrivate(userName, keystoreUrl);
                pass = rs.getString("pass_word");
                if(key != null) {
                    pass = RSAUtil.privateDecrypt(pass, key);
                }
                if(pass.equals(password)){
                    // 账号密码正确则创建token
                    String token = CommonUtils.createJWT(userName, 30 * 60 * 1000);
                    return token;
                }else{
                    return "";
                }
            }else{
                return "";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        } finally {
            // 关闭连接
            try {
                rs.close();
                pstmt.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
