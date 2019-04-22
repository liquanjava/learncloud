package com.liquan.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableEurekaClient
@EnableHystrix
public class DeptProviderHystrix8001_App {

    public static void main(String[] args) {

        SpringApplication.run(DeptProviderHystrix8001_App.class,args);
    }
}
