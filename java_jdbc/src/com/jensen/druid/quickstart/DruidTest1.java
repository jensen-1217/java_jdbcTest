package com.jensen.druid.quickstart;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.jensen.jdbc.util.JdbcUtil;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class DruidTest1 {
    @Test
    public void testDruid() throws Exception {

        Properties prop = new Properties();
        prop.load(new FileInputStream("druid.properties"));

       DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);
        Connection coon = dataSource.getConnection();
        String sql="select id,username,password from user";
        PreparedStatement pstmt = coon.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()){
            System.out.print(rs.getString("username")+"\t");
            System.out.print(rs.getString("password")+"\t");
            System.out.println(rs.getInt("id"));
            System.out.println("-------------------------");
        }
        JdbcUtil.close(coon,pstmt,rs);
    }
}
