package com.unihubcrew.unihub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.mybatis.spring.annotation.MapperScan;

@MapperScan("com.unihubcrew.unihub.mapper")
@SpringBootApplication
public class UnihubApplication {

    public static void main(String[] args) {
        SpringApplication.run(UnihubApplication.class, args);
    }

}
