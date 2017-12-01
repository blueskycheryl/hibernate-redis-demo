package com.xyshmily.hibernate.redis.demo;

import com.xyshmily.hibernate.redis.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.QueryHints;

import javax.persistence.QueryHint;
import java.util.List;


/**
 * Created by xyshmily on 2017/11/30.
 */
public interface UserRepository extends JpaRepository<User, String> {

    @QueryHints({@QueryHint(name = "org.hibernate.cacheable", value = "true")})
    User findByName(String name);

    @QueryHints({@QueryHint(name = "org.hibernate.cacheable", value = "true")})
    List<User> findAll();
}
