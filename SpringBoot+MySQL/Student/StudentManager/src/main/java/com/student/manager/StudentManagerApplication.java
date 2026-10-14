package com.student.manager;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.student.manager.mapper")
public class StudentManagerApplication {
    public static void main(String[] args) {
        SpringApplication.run(StudentManagerApplication.class, args);
    }
}
