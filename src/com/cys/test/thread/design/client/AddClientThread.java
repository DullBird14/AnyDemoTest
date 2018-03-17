package com.cys.test.thread.design.client;

import com.cys.test.thread.design.active.ActiveObject;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class AddClientThread extends Thread {
    private ActiveObject object;

    AddClientThread(String testA, ActiveObject object) {
        super(testA);
        this.object = object;
    }

    @Override
    public void run() {
        String x = "1";
        String y = "1";
        for (int i = 0; true ; i++) {
            Future<String> stringFuture = object.caculateSum(x, y);
            try {
                String s = stringFuture.get();
                System.out.println(x + " + " + y + " = " + s +"\r\n");
                x = y;
                y = s;
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}
