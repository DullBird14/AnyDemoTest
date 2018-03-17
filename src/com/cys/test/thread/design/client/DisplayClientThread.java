package com.cys.test.thread.design.client;

import com.cys.test.thread.design.active.ActiveObject;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class DisplayClientThread extends Thread {
    private ActiveObject object;

    public DisplayClientThread(String testA, ActiveObject object) {
        super(testA);
        this.object = object;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10 ; i++) {
            object.displayString(i +"");
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
