package com.lty.threadpool;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.lty.threadpool.sys.mapper")
public class ThreadpoolApplication {

    public static void main(String[] args) {
        SpringApplication.run(ThreadpoolApplication.class, args);
    }

}
