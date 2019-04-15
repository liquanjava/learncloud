package com.liquan.springcloud.controller;


import com.liquan.entity.Dept;
import com.liquan.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeptController {
    @Autowired
    private DeptService service;
    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "/dept/add", method = RequestMethod.POST)
    public boolean add(@RequestBody Dept dept) {
        return service.add(dept);
    }

    @RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
    public Dept get(@PathVariable("id") Long id) {
        return service.get(id);
    }

    @RequestMapping(value = "/dept/list", method = RequestMethod.GET)
    public List<Dept> list() {
        return service.list();
    }

    @RequestMapping(value = "/dept/discovery", method = RequestMethod.GET)
    public Object discovery() {
        List<String> serviceslist = client.getServices();
        System.out.println("serverlist---"+serviceslist);
        List<ServiceInstance> instances = client.getInstances("learncloud-dept");
        instances.forEach(x->{
            System.out.println(x.getServiceId()+"\t"+x.getHost()+"\t"+x.getPort()+"\t"+x.getUri());
        });

        return this.client;
    }


}
