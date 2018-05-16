package com.cys.test.thread.design.active;

import java.util.concurrent.Future;

class Servant implements ActiveObject{
    @Override
    public Future<String> makeString(String context, int count) {
        return null;
    }

    @Override
    public void displayString(String show) {

    }

    @Override
    public Future<String> caculateSum(String a, String b) {
        return null;
    }
}
