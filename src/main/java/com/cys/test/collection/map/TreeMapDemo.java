package com.cys.test.collection.map;

import java.util.Comparator;
import java.util.TreeMap;

/**
 * 1.如果没有定义比较方式，并且传入的对象没有实现Comparable接口的话会报错。
 * 2.利用红黑树实现，具体逻辑需要查看数据结构
 */
public class TreeMapDemo {
    public static void main(String[] args) {
//        TreeMap map = new TreeMap(new Comparator() {
//            @Override
//            public int compare(Object o1, Object o2) {
//                return 0;
//            }
//        });
        TreeMap map = new TreeMap();
//        Object a = new Object();
//        Object b = new Object();
//
//        map.put(a, 11);
//        map.put(b, 11);
        map.put(1, "语文");
        map.put(3, "英语");
        map.put(2, "数学");
        map.put(4, "政治");
        map.put(5, "历史");
        map.put(6, "地理");
        map.put(7, "生物");
        map.put(8, "化学");
        System.out.println(map);
    }
}
