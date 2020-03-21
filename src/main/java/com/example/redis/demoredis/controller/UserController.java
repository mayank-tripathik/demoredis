package com.example.redis.demoredis.controller;

import com.example.redis.demoredis.model.User;
import com.example.redis.demoredis.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/index")
    public String index(){
        return "Hello user";
    }

    @GetMapping("/create/{id}/{name}")
    public User create(@PathVariable("id") final int id, @PathVariable("name") final String name) {
        userService.add(new User(id, name));
        return userService.fetchById(id);
    }

    @GetMapping("/update/{id}/{name}")
    public User update(@PathVariable("id") final int id, @PathVariable("name") final String name) {
        userService.update(new User(id, name));
        return userService.fetchById(id);
    }

    @GetMapping("/delete/{id}")
    public Map<Integer, User> delete(@PathVariable("id") final int id) {
        userService.remove(id);
        return userService.fetchAll();
    }
    @GetMapping("/all")
    public Map<Integer, User> retrieveAll() {
        return userService.fetchAll();
    }
}
