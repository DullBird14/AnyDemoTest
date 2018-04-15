package com.cys.boot.advance.condition;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConditionConfig.class);
        ConditionService bean = context.getBean(ConditionService.class);
        System.out.println(bean.fileListCommand());
        context.close();
    }
}
