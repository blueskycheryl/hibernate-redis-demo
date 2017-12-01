package com.xyshmily.hibernate.redis.demo;

import com.xyshmily.hibernate.redis.demo.model.User;

import java.util.List;

/**
 * Created by xyshmily on 2017/11/30.
 */
public interface UserService {

    List<User> listUser();

    User getOne(String id);

    User save(User user);

    User getByName(String name);
}
