package com.cys.test.thread.design.active;

import java.util.concurrent.Future;

/**
 * 对外开放的接口
 */
public interface ActiveObject {
    Future<String> makeString(String context, int count);
    void displayString(String show);
    Future<String> caculateSum(String a, String b);
}
