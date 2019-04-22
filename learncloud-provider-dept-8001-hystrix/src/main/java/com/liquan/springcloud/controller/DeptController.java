package com.liquan.springcloud.controller;


import com.liquan.entity.Dept;
import com.liquan.springcloud.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.mockito.internal.exceptions.ExceptionIncludingMockitoWarnings;
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
    @HystrixCommand(fallbackMethod = "afterError")
    public Dept get(@PathVariable("id") Long id) throws Exception {

        Dept dept = service.get(id);
        //Thread.sleep(20000000);
        if (dept == null) {
            throw new RuntimeException("异常啦   错误啦，快控制住");
        }
        return dept;
    }

    @RequestMapping(value = "/dept/list",method = RequestMethod.GET)
    public List<Dept> list() {
        return service.list();
    }

    @RequestMapping(value = "/dept/discovery", method = RequestMethod.GET)
    public Object discovery() {
        List<String> serviceslist = client.getServices();
        System.out.println("serverlist---" + serviceslist);
        List<ServiceInstance> instances = client.getInstances("learncloud-dept");
        instances.forEach(x -> {
            System.out.println(x.getServiceId() + "\t" + x.getHost() + "\t" + x.getPort() + "\t" + x.getUri());
        });

        return this.client;
    }

    public Dept afterError(@PathVariable("id") Long id) {
        System.out.println("熔断器");
        return new Dept().setDeptName("32");
    }
}
