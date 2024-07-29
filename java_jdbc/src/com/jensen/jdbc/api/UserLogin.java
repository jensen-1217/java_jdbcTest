package com.jensen.jdbc.api;

import org.junit.Test;

import java.sql.*;

public class UserLogin {
    @Test
    public void loginTest() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        final String URL="jdbc:mysql://127.0.0.1:3306/db5";
        final String USERNAME="root";
        final String PASSWORD="root";
        Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        String username="SunWuKong";
        String password="SunWuKong";
        String sql="select * from user where username=? and password=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1,username);
        pstmt.setString(2,password);
        ResultSet rs = pstmt.executeQuery();
        //Statement stmt = conn.createStatement();
        //ResultSet rs = stmt.executeQuery(sql);
        if (rs.next()){
            String name = rs.getString("NAME");
            System.out.println(name+"登陆成功");
        }else {
            System.out.println("登录失败");
        }
        rs.close();
        pstmt.close();
        conn.close();


    }
}
