package com.liquan.springcloud.Service;

import com.liquan.entity.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DeptClientServerFallBackFactory implements FallbackFactory<Service> {
    @Override
    public Service create(Throwable throwable) {
        return new Service() {
            @Override
            public Dept getDept(long id) {
                return new Dept().setDeptName("服务已降级");
            }

            @Override
            public List<Dept> list() {
                return null;
            }
        };

    }
}
