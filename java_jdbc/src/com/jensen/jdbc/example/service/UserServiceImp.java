package com.jensen.jdbc.example.service;

import com.jensen.jdbc.example.dao.UserDaoImp;
import com.jensen.jdbc.example.pojo.User;

public class UserServiceImp implements UserService {

    @Override
    public boolean userLogin(User loginUser){
        if (loginUser==null){
            throw new RuntimeException("传递的参数为null");
        }

        UserDaoImp userDaoImp =new UserDaoImp();
        User user= userDaoImp.login(loginUser);
        if (user!=null){
            System.out.println(user);
            return true;
        }


        return false;
    }
}
