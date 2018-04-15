package com.cys.test.boot.advance.schedule;

import com.cys.test.boot.advance.aware.AwareConfig;
import com.cys.test.boot.advance.aware.AwareService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ScheduleConfig.class);
        ScheduleService bean = context.getBean(ScheduleService.class);
//        bean.testCron();
//        bean.testFixedRate();
//        context.close();
    }
}
