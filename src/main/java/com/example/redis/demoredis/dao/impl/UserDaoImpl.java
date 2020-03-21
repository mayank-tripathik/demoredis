package com.example.redis.demoredis.dao.impl;

import com.example.redis.demoredis.dao.UserDao;
import com.example.redis.demoredis.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;


@Repository
public class UserDaoImpl implements UserDao {

    private final String HASH = "USER";

    @Autowired
    private RedisTemplate<String, User> redisTemplate;

    // we cannot operate with redistemplate directly, we need hash operations for this redistemplate
    private HashOperations hashOperations;

    public UserDaoImpl(RedisTemplate<String, User> redisTemplate) {
        this.hashOperations = redisTemplate.opsForHash();
    }

    @Override
    public void create(User user) {
        hashOperations.put(HASH, user.getId(), user);
    }

    @Override
    public void update(User user) {
        create(user);
    }

    @Override
    public void delete(int id) {
        hashOperations.delete(HASH, id);
    }

    @Override
    public Map<Integer, User> retrieve() {
        return hashOperations.entries(HASH);
    }

    @Override
    public User findById(int id) {
        return (User)hashOperations.get(HASH, id);
    }
}
