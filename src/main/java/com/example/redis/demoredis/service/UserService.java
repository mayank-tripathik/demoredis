package com.example.redis.demoredis.service;

import com.example.redis.demoredis.model.User;

import java.util.Map;

public interface UserService {

    void add(User user);

    void update(User user);

    void remove(int id);

    Map<Integer, User> fetchAll();

    User fetchById(int id);
}
