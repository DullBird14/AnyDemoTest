package com.cys.test.collection.set;

import java.util.HashSet;
/*
 *  1.利用了map的结构，内部是一个hashMap,仅仅使用了key 默认value是obejct
 */
public class HashSetDemo {
    public static void main(String[] args) {
        HashSet hashSet = new HashSet();
        hashSet.add(new Object());
    }
}
