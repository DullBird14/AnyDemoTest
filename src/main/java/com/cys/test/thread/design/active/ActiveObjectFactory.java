package com.cys.test.thread.design.active;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 包内唯一对外开放的
 */
public class ActiveObjectFactory {

    public static ActiveObject createObject(){
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Proxy proxy = new Proxy(executorService);
        return proxy;
    }
}
