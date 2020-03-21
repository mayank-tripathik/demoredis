package com.example.redis.demoredis.dao;

import com.example.redis.demoredis.model.User;

import java.util.List;
import java.util.Map;

public interface UserDao {

    void create(User user);

    void update(User user);

    void delete(int id);

    Map<Integer, User> retrieve();

    User findById(int id);
}
