package com.jensen.jdbc.util;

import java.sql.*;
import java.util.Scanner;

public class JdbcUtil {

    private static final String DRIVER="com.mysql.cj.jdbc.Driver";
    private static final String URL="jdbc:mysql://127.0.0.1:3306/db5";
    private static final String USERNAME="root";
    private static final String PASSWORD="root";

    static {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL,USERNAME,PASSWORD);
    }

    public static void close(Connection conn,Statement stmt){
        close(conn,stmt,null);
    }

    public static int id(){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要删除的id：");
        String s = sc.nextLine();
        return Integer.parseInt(s);
    }

    public static void close(Connection conn, Statement stmt, ResultSet rs){
        try {
            if (rs!=null) {
                rs.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            if (stmt!=null) {
                stmt.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            if (conn!=null) {
                conn.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
