package com.cys.test.collection.map;

import java.util.HashMap;

/**
 *  疑问继承类AbstractMap并且实现了map接口,但是AbstractMap已经实现了map接口
 *  可能是为了方便替换继承类
 *  1.初始化容量为16
 *
 *
 */
public class HashMapDemo {
    public static void main(String[] args) {
        HashMap map = new HashMap();
    }
}
