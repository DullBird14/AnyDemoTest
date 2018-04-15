package com.cys.test.boot.base.event;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(EventConfig.class);
        EventPublisher bean = context.getBean(EventPublisher.class);
        bean.publisher(" test test test three");
        context.close();
    }
}
