package com.cys.test.thread.design.active;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * 调度执行和队列控制
 */
class Scheduler implements Runnable {
    private LinkedBlockingQueue<Request> queue;

    Scheduler() {
        this.queue = new LinkedBlockingQueue<>();
    }

    void putRequest(Request req){
        try {
            queue.put(req);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true) {
            Request take = null;
            try {
                take = queue.take();
                take.exectue();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
