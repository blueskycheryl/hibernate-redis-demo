package com.xyshmily.hibernate.redis.demo;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * Created by xyshmily on 2017/11/30.
 */
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        new SpringApplicationBuilder(Application.class)
                .bannerMode(Banner.Mode.CONSOLE)
                .run(args);
    }

}
