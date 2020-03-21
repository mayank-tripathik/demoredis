package com.example.redis.demoredis;

import com.example.redis.demoredis.model.User;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;


// Redis is keystore-based data structure to persist data and can be used as a database, cache, message broker, etc.
@SpringBootApplication
public class DemoredisApplication {

    // putting it as bean so that this method will be set in spring context whenever required
    // Jedis is a java redis client. redis client is needed to connect to redis server
    @Bean
    JedisConnectionFactory jedisConnectionFactory() {
        return new JedisConnectionFactory();
    }

    // putting it as bean so that this method will be set in spring context whenever required
    // Redistemplate is used to query data to a custom repository, user here
    @Bean
    RedisTemplate<String, User> redisTemplate() {
        RedisTemplate<String, User> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(jedisConnectionFactory());
        return redisTemplate;
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoredisApplication.class, args);
    }

}
