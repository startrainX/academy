package com.project.eduservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author: zsp
 * @Description:
 * @Date: Create in 7:32 2020/4/29
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.project"})
public class EduTeacherApplication {
    public static void main(String[] args) {
        SpringApplication.run(EduTeacherApplication.class, args);
    }
}
