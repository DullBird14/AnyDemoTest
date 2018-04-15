package com.cys.boot.advance.taskExecutors;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TaskExectorsConfig.class);
        AsyncTaskService bean = context.getBean(AsyncTaskService.class);

        for (int i = 0; i < 4; i++) {
            bean.executeAsyncTask(i);
            bean.executeAsyncTaskPlus(i);
        }
        System.out.println("over");
        context.close();
    }
}
