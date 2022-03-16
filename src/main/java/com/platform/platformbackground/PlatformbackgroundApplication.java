package com.platform.platformbackground;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("com.platform.platformbackground.repository")
@SpringBootApplication
public class PlatformbackgroundApplication {

    public static void main(String[] args) {
        SpringApplication.run(PlatformbackgroundApplication.class, args);
    }

}
