package com.demo.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class BackendApplication {
    public static ConfigurableApplicationContext AC;

    public static void main(String[] args) {
        AC=SpringApplication.run(BackendApplication.class, args);
    }

}
