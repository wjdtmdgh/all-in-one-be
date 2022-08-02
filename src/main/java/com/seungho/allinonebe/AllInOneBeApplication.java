package com.seungho.allinonebe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class AllInOneBeApplication {

    public static void main(String[] args) {
        SpringApplication.run(AllInOneBeApplication.class, args);
    }

}
