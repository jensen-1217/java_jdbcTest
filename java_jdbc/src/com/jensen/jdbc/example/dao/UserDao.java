package com.jensen.jdbc.example.dao;

import com.jensen.jdbc.example.pojo.User;

import java.util.List;

public interface UserDao {
    User login(User loginUser);
    int addUser(User user);
    int deleteUser(User user);
    List<User> findAllUser();
}
