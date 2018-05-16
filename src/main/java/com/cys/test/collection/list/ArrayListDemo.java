package com.cys.test.collection.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  ArrayList
 *  1.默认长度10
 *  2.增长策略是 0.5倍增长
 *  3.获取指定位置或者设置,get(i),set(i, a)性能很高.末尾插入性能也很高add(end)
 *  4.中间移除和插入性能很差,要整体复制移动.
 */

public class ArrayListDemo {
    public static void main(String[] args) {
//        ArrayList<String> list = new ArrayList<String>();
//        int i = Integer.MAX_VALUE+1;
//        System.out.println(i);
//        testArrayListInitCollection();
        testOOM();

    }

    //c.toArray might (incorrectly) not return Object[] (see 6260652)
    public static void testArrayListInitCollection(){
        List<String> test = Arrays.asList("abc");
        ArrayList<String> strings = new ArrayList<>();
        Object[] object1 = test.toArray();
        System.out.println(object1.getClass());
        //class [Ljava.lang.String;

        List<String> arraysTest = new ArrayList<String>(test);
        Object[] object2 = arraysTest.toArray();
        System.out.println(object2.getClass());
        //class [Ljava.lang.Object;
    }

    public static void testOOM(){
        int oldCapacity = Integer.MAX_VALUE - 16;
        System.out.println(oldCapacity);
        int minCapacity = Integer.MAX_VALUE - 15;
        int maxSize = Integer.MAX_VALUE - 8;
        int newCapacity = oldCapacity + (oldCapacity >> 1);

        if (newCapacity - minCapacity < 0)
            newCapacity = minCapacity;
        if (newCapacity - maxSize > 0)
            newCapacity = hugeCapacity(minCapacity);
        // minCapacity is usually close to size, so this is a win:
        System.out.println(newCapacity);
    }

    private static int hugeCapacity(int minCapacity) {
        if (minCapacity < 0) // overflow
            throw new OutOfMemoryError();
        return (minCapacity > Integer.MAX_VALUE - 8) ?
                Integer.MAX_VALUE :
                Integer.MAX_VALUE - 8;
    }
}
