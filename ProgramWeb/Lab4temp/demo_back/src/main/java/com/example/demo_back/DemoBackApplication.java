package com.example.demo_back;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DemoBackApplication {
    public static ConfigurableApplicationContext AC;

    public static void main(String[] args) {
        AC=SpringApplication.run(DemoBackApplication.class, args);
    }

}
