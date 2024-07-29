package com.jensen.druid.example;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.jensen.jdbc.util.JdbcUtil;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class BrandDao {
    public List<Brand> findAllBrand() throws Exception {

        Properties properties = new Properties();
        InputStream is = BrandDao.class.getClassLoader().getResourceAsStream("jdbc.properties");
        properties.load(is);

        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
        Connection conn = dataSource.getConnection();
        String sql="select id, brand_name, company_name, ordered, description, status from tb_brand";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();

        List<Brand> brandList=new ArrayList<>();
        while (rs.next()){
            int id = rs.getInt("id");
            String brandName = rs.getString("brand_name");
            String companyName = rs.getString("company_name");
            int ordered = rs.getInt("ordered");
            String description = rs.getString("description");
            int status = rs.getInt("status");

            Brand brand = new Brand(id, brandName, companyName, ordered, description, status);

            brandList.add(brand);

        }
        rs.close();
        pstmt.close();
        conn.close();

        return brandList;
    }

    public int addBrand(Brand brand){
        return 0;
    }

    public int updateBrand(Brand brand){
        return 0;
    }

    public int deleteBrand(Brand brand){
        return 0;
    }
}
