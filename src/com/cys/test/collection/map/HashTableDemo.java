package com.cys.test.collection.map;

import java.util.Hashtable;

/**
 * 初始化长度11，扩容策略是2*容量+1
 * 1.线程安全
 * 2.不支持null的key。
 * 没有ConcurrentHashMap性能高
 */
public class HashTableDemo {
    public static void main(String[] args) {
        Hashtable hashtable = new Hashtable();
    }
}
