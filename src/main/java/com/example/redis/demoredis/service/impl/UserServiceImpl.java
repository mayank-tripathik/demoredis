package com.example.redis.demoredis.service.impl;

import com.example.redis.demoredis.dao.UserDao;
import com.example.redis.demoredis.model.User;
import com.example.redis.demoredis.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public void add(User user) {
        userDao.create(user);
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    public void remove(int id) {
        userDao.delete(id);
    }

    @Override
    public Map<Integer, User> fetchAll() {
        return userDao.retrieve();
    }

    @Override
    public User fetchById(int id) {
        return userDao.findById(id);
    }
}
