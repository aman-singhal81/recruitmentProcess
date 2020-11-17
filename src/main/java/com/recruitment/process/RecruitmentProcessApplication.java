package com.recruitment.process;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;



@EnableAutoConfiguration
@SpringBootApplication
public class RecruitmentProcessApplication {

    public static void main(String[] args) {
        SpringApplication.run(RecruitmentProcessApplication.class, args);
    }
}
