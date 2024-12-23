package com.dao;

import java.util.List;

import com.model.User;

public interface UserDAO {
    int addUser(User user);
    List<User> getAllUsers();
    int updateUser(User user);
    int deleteUser(int id);
}
