package com.example.example.service;

import com.example.example.entity.User;
import com.example.example.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService implements UserServiceInter{

    private final UserRepository repository;
    @Override
    public User update(User user,Long id) {
        return repository.update(user,id);
    }



    @Override
    public User creat(User user) {
        return repository.creat(user);
    }

    @Override
    public void delete(Long id) {
        repository.delete(id);
    }

    @Override
    public List<User> getAll(User user) {
        return null;
    }

    @Override
    public User getById(User user) {
        return null;
    }
}
