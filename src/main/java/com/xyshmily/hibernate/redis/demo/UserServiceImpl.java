package com.xyshmily.hibernate.redis.demo;

import com.xyshmily.hibernate.redis.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xyshmily on 2017/11/30.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> listUser() {
        return userRepository.findAll();
    }

    @Override
    public User getOne(String id) {
        return userRepository.findOne(id);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getByName(String name) {
        return userRepository.findByName(name);
    }
}
