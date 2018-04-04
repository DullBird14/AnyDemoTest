package com.cys.test.thread;

public class ThreadNotSeenEachOther {
    public static void main(String[] args) throws InterruptedException {
        ThreadA A = new ThreadA("ThreadA");
        A.start();
        Thread.sleep(5000);
        A.setMark(true);
        A.join();
    }
}

class ThreadA extends Thread{
    private static boolean mark;

    public ThreadA(String name) {
        super(name);
    }

    public void setMark(final boolean mark){
        this.mark = mark;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " start to run!");
        while (!mark){
            System.out.println("mark is false");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("mark change!!");
    }
}
