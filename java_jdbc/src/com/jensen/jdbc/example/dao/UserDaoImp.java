package com.jensen.jdbc.example.dao;

import com.jensen.jdbc.example.pojo.User;
import com.jensen.jdbc.util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDaoImp implements UserDao {
    User user=null;
    Connection conn=null;
    PreparedStatement pstmt=null;
    ResultSet rs=null;

    @Override
    public User login(User loginUser){
        try {
            conn = JdbcUtil.getConnection();
            String sql="select id,username,password from user where username=? and password=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,loginUser.getUserName());
            pstmt.setString(2,loginUser.getPassword());
            rs = pstmt.executeQuery();
            if (rs!=null && rs.next()){
                String username = rs.getString("username");
                String password = rs.getString("password");
                int id = rs.getInt("id");
                user=new User(id,username,password);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JdbcUtil.close(conn,pstmt,rs);
        }
        return user;
    }

    @Override
    public int addUser(User user) {
        return 0;
    }

    @Override
    public int deleteUser(User user) {
        return 0;
    }

    @Override
    public List<User> findAllUser() {
        return null;
    }

}
