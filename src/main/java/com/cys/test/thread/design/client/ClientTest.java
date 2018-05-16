package com.cys.test.thread.design.client;

import com.cys.test.thread.design.active.ActiveObject;
import com.cys.test.thread.design.active.ActiveObjectFactory;

public class ClientTest {

    public static void main(String[] args) {
        ActiveObject object = ActiveObjectFactory.createObject();
//        new MakerClientThread("testA", object).start();
//        new MakerClientThread("testB", object).start();
//        new DisplayClientThread("testC", object).start();
        new AddClientThread("testC", object).start();
    }
}
