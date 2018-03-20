package com.cys.test.zookeeper;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;

class Master implements Watcher {
    ZooKeeper zooKeeper;
    String hostPort;

    public Master(String hostPort) {
        this.hostPort = hostPort;
    }

    void startZk() throws IOException {
        zooKeeper = new ZooKeeper(hostPort, 15000, this);
    }

    public void process(WatchedEvent watchedEvent) {
        System.out.println(watchedEvent);
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        Master master = new Master("127.0.0.1:2181");
        master.startZk();
        Thread.sleep(60000);
    }
}
