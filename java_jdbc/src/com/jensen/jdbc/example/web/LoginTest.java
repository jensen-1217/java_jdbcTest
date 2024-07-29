package com.jensen.jdbc.example.web;

import com.jensen.jdbc.example.pojo.User;
import com.jensen.jdbc.example.service.UserServiceImp;
import org.junit.Test;

public class LoginTest {
    @Test
    public void login(){
        String loginName="admin";
        String loginPassword="12345";

        User loginUser = new User();
        loginUser.setUserName(loginName);
        loginUser.setPassword(loginPassword);

        UserServiceImp userServiceImp = new UserServiceImp();
        boolean loginResult = userServiceImp.userLogin(loginUser);

        if (loginResult){
            System.out.println("给客户端返回信息：登陆成功");
        }else {
            System.out.println("给客户端返回信息：登录失败");
        }


    }
}
