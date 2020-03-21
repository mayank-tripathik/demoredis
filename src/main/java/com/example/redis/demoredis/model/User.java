package com.example.redis.demoredis.model;

import java.io.Serializable;


public class User implements Serializable {
    private int id;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
