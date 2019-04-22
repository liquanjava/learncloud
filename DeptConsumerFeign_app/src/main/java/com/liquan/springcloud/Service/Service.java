package com.liquan.springcloud.Service;

import com.liquan.entity.Dept;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "learncloud-dept", fallbackFactory = DeptClientServerFallBackFactory.class)
public interface Service {

    @GetMapping("/dept/get/{id}")
    Dept getDept(@PathVariable("id") long id);

    @GetMapping("/dept/list")
    List<Dept> list();

}
