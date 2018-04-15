package com.cys.boot.base.profile;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.getEnvironment().setActiveProfiles("prod");
        context.register(ProfileConfig.class);
        context.refresh();

//        DemoBean bean = context.getBean(DemoBean.class);
        DemoDevBean bean1 = context.getBean(DemoDevBean.class);
        bean1.test();
        context.close();
    }
}
