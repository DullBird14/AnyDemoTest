package com.cys.test.thread.design.two.phase;

public class TestUncaughtAndInterrupt {

    public static void main(String[] args) {
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                e.printStackTrace();
                System.out.println(t.getName() + ":: ERROR");
            }
        });

        Runtime time = Runtime.getRuntime();
        time.addShutdownHook(new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        }));
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    throw new NullPointerException();
                } catch (Exception e) {

                }
            }
        }, "test").start();
    }
}
