package com.cys.test.boot.aop;

import org.springframework.stereotype.Service;

@Service
public class DemoAnnotationService {
    @Action(name = "注解式拦截器")
    public void add(){
        System.out.println("DemoAnnotationService");
    };
}
