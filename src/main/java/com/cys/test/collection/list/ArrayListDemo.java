package com.cys.test.collection.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Spliterator;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.function.Consumer;

/**
 *  ArrayList
 *  1.默认长度10
 *  2.增长策略是 0.5倍增长
 *  3.获取指定位置或者设置,get(i),set(i, a)性能很高.末尾插入性能也很高add(end)
 *  4.中间移除和插入性能很差,要整体复制移动.
 */

public class ArrayListDemo {
    public static void main(String[] args) {
        new LinkedBlockingQueue<>();
        ArrayList<String> list = new ArrayList<String>();
        testSpliterator();
//        testRemoveAll();
//        testRemove();
//        list.set(-1, null);
//        int i = Integer.MAX_VALUE+1;
//        System.out.println(i);
//        testArrayListInitCollection();
//        testOOMCondition();

    }
    public static void testSpliterator(){
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
        ArrayList<Integer> list = new ArrayList<>(integers);
        Spliterator<Integer> a = list.spliterator();
//        a.tryAdvance(new Consumer<Integer>() {
//            @Override
//            public void accept(Integer integer) {
//                System.out.println(integer);
//            }
//        });
        Spliterator<Integer> b = a.trySplit();
        Spliterator<Integer> c = a.trySplit();
        System.out.println("==========a=================");
        a.forEachRemaining(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        });
        System.out.println("==========b=================");
        b.forEachRemaining(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        });
        System.out.println("============c===============");
        c.forEachRemaining(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        });
    }

    public static void testRemoveAll(){
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        ArrayList<Integer> list = new ArrayList<>(integers);
        list.removeAll(Arrays.asList(1,4,7));
        System.out.println(list);
    }
    public static void testRemove(){
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        ArrayList<Integer> list = new ArrayList<>(integers);
        System.out.println(list);
        list.remove(3);
        System.out.println(list);

    }
    public static void testSystemArrayCopy(){
        int[] intArray = new int[]{1,2,3,4,5,6,7};
        System.arraycopy(intArray, 0, intArray, 1, 3);
        System.out.println(Arrays.toString(intArray));
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

    public static void testOOMCondition(){
        int minCapacity = Integer.MAX_VALUE +1;
        System.out.println(minCapacity);
        System.out.println(minCapacity - 100);
    }
}
