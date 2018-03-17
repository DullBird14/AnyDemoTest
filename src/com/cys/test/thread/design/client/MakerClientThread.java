package com.cys.test.thread.design.client;

import com.cys.test.thread.design.active.ActiveObject;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class MakerClientThread extends Thread {
    private ActiveObject object;

    public MakerClientThread(String testA, ActiveObject object) {
        super(testA);
        this.object = object;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10 ; i++) {
            Future<String> a = object.makeString("A", i);
            try {
                Thread.sleep(10);
                String s = a.get();
                System.out.println("make String " + Thread.currentThread().getName()
                        + "::" + s);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}
