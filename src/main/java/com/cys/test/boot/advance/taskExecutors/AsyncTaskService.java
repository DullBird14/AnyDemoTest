package com.cys.test.boot.advance.taskExecutors;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncTaskService {
    @Async
    public void executeAsyncTask(Integer integer){
        System.out.println("执行异步任务:" + integer);
        System.out.println("executeAsyncTask over" + (integer));

    }
    @Async
    public void executeAsyncTaskPlus(Integer integer){
        System.out.println("执行异步任务+1:" + (integer + 1));
        System.out.println("executeAsyncTaskPlus over" + (integer + 1));
    }
}
