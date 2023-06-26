package com.example.example.controller;

import com.example.example.entity.User;
import com.example.example.service.UserServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserServiceInter service;

    @GetMapping("/{id}")
    public User getById(@PathVariable(value = "id") @RequestBody User user){
        return service.getById(user);
    }
    @GetMapping()
    public List<User> getAll(@RequestBody User user){
        return service.getAll(user);
    }
    @PostMapping()
    public User creat(@RequestBody User user){
        return service.creat(user);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete (@PathVariable(value = "id") Long id){
        service.delete(id);
    }
    @PutMapping("/{id}")
    public User update(@PathVariable(value = "id") Long id,@RequestBody User user){
        return  service.update(user,id);
    }

}
