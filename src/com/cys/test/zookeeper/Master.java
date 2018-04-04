package com.cys.test.zookeeper;

import org.apache.log4j.Logger;
import org.apache.zookeeper.*;
import org.apache.zookeeper.data.ACL;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.Random;

class Master implements Watcher {

    private static final Logger LOGGER = Logger.getLogger(Master.class);

    ZooKeeper zooKeeper;
    String hostPort;
    private boolean isleader;
    private String serverId ;
    private AsyncCallback.DataCallback getDataCallBack;
    private AsyncCallback.StringCallback createCallBack;
    public Master(String hostPort) {
        this.hostPort = hostPort;
        serverId = Integer.toHexString(new Random().nextInt());
        getDataCallBack = new AsyncCallback.DataCallback() {
            @Override
            public void processResult(int i, String s, Object o, byte[] bytes, Stat stat) {
                switch (KeeperException.Code.get(i)) {
                    case CONNECTIONLOSS:
                        checkMasterByCallBack();
                        return;
                    case NONODE:
                        runForMasterCallBack();
                        return;
                    case OK:
                        isleader = true;
                        return;
                }
            }
        };
        createCallBack = new AsyncCallback.StringCallback(){
            @Override
            public void processResult(int responseCode, String path, Object ctx, String name) {
                switch (KeeperException.Code.get(responseCode)) {
                    case CONNECTIONLOSS:
                        //判断是否为主节点
                        checkMasterByCallBack();
                        return;
                    case OK:
                        isleader = true;
                        break;
                    default:
                        isleader = false;
                }

                LOGGER.info("我是主节点么？" + isleader);
            }
        };
    }

    void startZk() throws IOException {
        zooKeeper = new ZooKeeper(hostPort, 15000, this);
    }

    public void process(WatchedEvent watchedEvent) {
        System.out.println(watchedEvent);
        System.out.println("触发了回调事件！！！");
    }

    void runForMaster() throws InterruptedException {
        while (true) {
            try {
//                if (true){
//                    throw new KeeperException.NoNodeException();
//                }
                zooKeeper.create("/master", serverId.getBytes(),
                        ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
                isleader = true;
                break;
            } catch (KeeperException.NoNodeException e) {
                e.printStackTrace();
            } catch (KeeperException.ConnectionLossException e) {
                e.printStackTrace();
            } catch (KeeperException e) {
                e.printStackTrace();
            }

            if (checkMaster()) {
                break;
            }
            Thread.sleep(3000);
        }

    }

    void runForMasterCallBack(){
        zooKeeper.create("/master", serverId.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE,
                CreateMode.EPHEMERAL, createCallBack, null );
    }

    private boolean checkMasterByCallBack(){
        zooKeeper.getData("/master", false, getDataCallBack, null);
        return false;
    }

    private boolean checkMaster(){
        while (true) {
            try {
                Stat stat = new Stat();
                byte[] data = zooKeeper.getData("/master", false, stat);
                System.out.println("查看data的状态如下:" + new String(data).toString());
                System.out.println("查看Stat的状态如下:" + stat.toString());
                isleader = new String(data).equals(serverId);
                return true;
            } catch (KeeperException.NoNodeException e) {
                e.printStackTrace();
                return false;
            } catch (KeeperException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
    public static void main(String[] args) throws IOException, InterruptedException {
        Master master = new Master("127.0.0.1:2181");
        master.startZk();
        master.runForMasterCallBack();
        Thread.sleep(60000);
    }
}
