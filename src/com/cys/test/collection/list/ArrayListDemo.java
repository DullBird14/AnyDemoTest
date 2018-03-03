package com.cys.test.collection.list;

import java.util.ArrayList;

/**
 *  ArrayList
 *  1.默认长度10
 *  2.增长策略是 0.5倍增长
 *  3.获取指定位置或者设置,get(i),set(i, a)性能很高.末尾插入性能也很高add(end)
 *  4.中间移除和插入性能很差,要整体复制移动.
 */

public class ArrayListDemo {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        int i = Integer.MAX_VALUE+1;
        System.out.println(i);
    }
}
