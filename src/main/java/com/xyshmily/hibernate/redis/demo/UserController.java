package com.xyshmily.hibernate.redis.demo;

import com.xyshmily.hibernate.redis.demo.model.User;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cache.redis.hibernate5.regions.RedisEntityRegion;
import org.hibernate.engine.spi.CacheImplementor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;

/**
 * Created by xyshmily on 2017/11/30.
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public Object listUser() {
        return userService.listUser();
    }

    @GetMapping("/find")
    public Object getOne(@RequestParam("id") String id) {
        return userService.getOne(id);
    }

    @GetMapping("/name")
    public Object getByName(@RequestParam("name") String name) {
        return userService.getByName(name);
    }

    @PostMapping("/save")
    public Object save(User user) {
        return userService.save(user);
    }

    @Autowired
    private EntityManager entityManager;

    @GetMapping("/cache")
    public void cacheInfo() {
        Session session = entityManager.unwrap(Session.class);
        log.info("user123={}", session.get(User.class, "123"));
        log.info("user1={}", session.get(User.class, "1"));
        SessionFactory sessionFactory = session.getSessionFactory();
        CacheImplementor cache = (CacheImplementor) sessionFactory.getCache();
        log.info("{}", cache.getAllSecondLevelCacheRegions());
        RedisEntityRegion redisEntityRegion = (RedisEntityRegion) cache.getSecondLevelCacheRegion("hibernate.common");
        redisEntityRegion.toMap().forEach((k, v) -> {
            log.info("\n k={},v={}", k, v);
        });
    }
}
