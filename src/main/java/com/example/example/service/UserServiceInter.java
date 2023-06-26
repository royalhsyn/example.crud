package com.example.example.service;

import com.example.example.entity.User;

import java.util.List;

public interface UserServiceInter {
    User update(User user,Long id);
    User creat(User user);
    void delete(Long id);
    List<User> getAll(User user);
     User getById(Long id,User user);
}
