package com.cys.test.thread.design.active;

import java.math.BigInteger;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

class Proxy implements ActiveObject {
//    private final Scheduler scheduler ;

    private final ExecutorService executorService;

//    private final Servant servant;

//    public Proxy(Scheduler scheduler, Servant servant) {
//        this.scheduler = scheduler;
//        this.servant = servant;
//    }

    public Proxy(ExecutorService executorService) {
        this.executorService = executorService;
    }
    @Override
    public Future<String> makeString(final String context, final int count) {
        class MakeStringRequest implements Callable<String>{

            @Override
            public String call() throws Exception {
                StringBuffer buffer = new StringBuffer();
                for (int i = 0; i < count; i++) {
                    buffer.append(context);
                }
                return buffer.toString();
            }
        }
        return executorService.submit(new MakeStringRequest());
    }

    @Override
    public void displayString(final String show) {
        class DisplyStringRequest implements Runnable{
            @Override
            public void run() {
                System.out.println("display " + show);
            }
        }
        executorService.execute(new DisplyStringRequest());
    }

    @Override
    public Future<String> caculateSum(final String a, final String b) {
        class AddRequset implements Callable<String>{

            @Override
            public String call() throws Exception {
                BigInteger bia = new BigInteger(a);
                BigInteger bib = new BigInteger(b);
                BigInteger add = bia.add(bib);
                return add.toString();
            }
        }
        return executorService.submit(new AddRequset());
    }
}
