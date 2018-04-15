package com.cys.boot.base.bean;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
        BeanWayService bean1 = context.getBean(BeanWayService.class);
        context.close();
    }
}
