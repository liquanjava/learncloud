package com.liquan.springcloud;

import com.liquan.springcloud.com.myrule.MyRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "LEARNCLOUD-DEPT",configuration = MyRule.class)
public class DeptConsumer80_App {


    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer80_App.class,args);
    }
}
