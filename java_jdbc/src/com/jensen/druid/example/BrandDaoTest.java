package com.jensen.druid.example;

import org.junit.Test;

import java.util.List;

public class BrandDaoTest {

    @Test
    public void testfindAllBrand() throws Exception {
        BrandDao brandDao = new BrandDao();
        List<Brand> brandList = brandDao.findAllBrand();
        for (Brand brand : brandList) {
            System.out.println(brand);
        }
    }

}
