package com.cys.test.collection.map;

import java.util.LinkedHashMap;

/**
 * 继承了hashMap
 * 1.存储是数组，结构是双向链表。
 * 2.根据构造器参数accessOrder，默认false提供按照插入循序遍历结果，如果为true则按照访问顺讯。
 * 3，在true模式下迭代器中遍历的时候，不能调用get()方法去获取元素，否则会报错ConcurrentModificationException
 */
public class LinkedHashMapDemo {
    public static void main(String[] args) {
        LinkedHashMap map = new LinkedHashMap();
        map.put("aaa",1);
        System.out.println();
    }
}
