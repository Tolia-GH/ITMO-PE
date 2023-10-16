package com.example.demo_back.configuration;

import com.example.demo_back.configuration.bean.DotBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class Beans {
    @Bean(name="dotBean")
    @Scope(value = "session")
    public DotBean dotBean(){
        return new DotBean();
    }
}

