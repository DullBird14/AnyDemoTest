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

        new Thread(new Runnable() {
            @Override
            public void run() {
                throw new NullPointerException();
            }
        }).start();
    }
}
