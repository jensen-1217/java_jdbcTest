package com.jensen.jdbc.review;

import com.jensen.jdbc.util.JdbcUtil;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class JdbcTest1 {
    private String driver="com.mysql.cj.jdbc.Driver";
    private String url="jdbc:mysql://127.0.01:3306/db5";
    private String username="root";
    private String password="root";
    @Test
    public void testInsert() throws ClassNotFoundException, SQLException {
//        Class.forName(driver);
//        Connection conn = DriverManager.getConnection(url, username, password);
        Connection conn = JdbcUtil.getConnection();
        String sql="insert into user(username,password)values(?,?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1,"admin");
        pstmt.setString(2,"123");
        int rowCount = pstmt.executeUpdate();
        if (rowCount>0){
            System.out.println("数据添加成功！");
        }else {
            System.out.println("数据添加失败！");
        }
        JdbcUtil.close(conn,pstmt);
    }

    @Test
    public void testDelete() throws ClassNotFoundException, SQLException {
//        Class.forName(driver);
//        Connection conn = DriverManager.getConnection(url, username, password);
        Connection conn = JdbcUtil.getConnection();
        String sql="delete from user where id=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        //int id = JdbcUtil.id();
        pstmt.setInt(1,6);
        long rowCount = pstmt.executeUpdate();
        if (rowCount>0){
            System.out.println("数据删除成功！");
        }else {
            System.out.println("数据删除失败！");
        }
//        pstmt.close();
//        conn.close();
        JdbcUtil.close(conn,pstmt);

    }

    @Test
    public void testUpdate(){
        Connection coon=null;
        String sql=null;
        try {
            coon = JdbcUtil.getConnection();
            coon.setAutoCommit(false);
            sql="update user set password=? where username=?";
            PreparedStatement pstmt = coon.prepareStatement(sql);
            pstmt.setString(1,"12345");
            pstmt.setString(2,"admin");
            int rowCount = pstmt.executeUpdate();
            if (rowCount>0){
                coon.commit();
                System.out.println("数据更新成功！");
            }else {
                coon.rollback();
                System.out.println("数据更新失败！");
            }
            JdbcUtil.close(coon,pstmt);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
