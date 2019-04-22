package com.liquan.springcloud.controller;

import com.liquan.entity.Dept;
import com.liquan.springcloud.Service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class Dept_CustomerController {

    @Autowired
    Service service;

    @GetMapping("/dept/get/{id}")
    public Dept getDept(@PathVariable("id")long id){
        return service.getDept(id);
    };

    @GetMapping("/dept/list")
    public List<Dept> list(){
        return service.list();
    };

}
