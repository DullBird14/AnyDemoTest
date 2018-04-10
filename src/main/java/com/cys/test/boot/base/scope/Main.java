package com.cys.test.boot.base.scope;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ScopConfig.class);

        DemoSingletonService bean = context.getBean(DemoSingletonService.class);
        DemoSingletonService bean1 = context.getBean(DemoSingletonService.class);

        DemoPrototypeService bean2 = context.getBean(DemoPrototypeService.class);
        DemoPrototypeService bean3 = context.getBean(DemoPrototypeService.class);

        System.out.println(bean.equals(bean1));
        System.out.println(bean2.equals(bean3));
        context.close();
    }
}
