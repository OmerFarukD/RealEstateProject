package com.qubitfaruk.realestateproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class RealEstateProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(RealEstateProjectApplication.class, args);
    }

}
