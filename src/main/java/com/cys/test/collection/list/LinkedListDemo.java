package com.cys.test.collection.list;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Spliterator;

/**
 * 双向链表,初始化的时候长度没有限制
 *  1.查找和设置的时候,get(i),set(i, a)需要遍历链表,会比较位置和size/2的大小,
 *  选择从前往后或者从后往前遍历.
 *  2.插入、删除元素时修改前后节点的指针即可，但还是要遍历部分链表的指针才能移动到下标所指的位置，
 *  只有在链表两头的操作—add(), addFirst(),removeLast()或用iterator()上的remove()能省掉指针的移动。
 *  3.中间元素频繁插入删除,使用LinkedList比较快
 */
public class LinkedListDemo {
    public static void main(String[] args) {
//        LinkedList list = new LinkedList();
//        list.add("b");
//        list.add("a");
//        list.add("c");
//        System.out.println(list);

//        testAddAll();
//        testPoll();
//        testClone();
//        testToArray();
        testTrySplit();
    }

    static void testAddAll(){
        LinkedList list = new LinkedList();
        list.add("b");
        list.add("a");
        list.add("c");
        list.addAll(list);
        System.out.println(list);
    }

    static void testPoll(){
        LinkedList list = new LinkedList();
        System.out.println(list.poll());
        System.out.println(list.poll());
        System.out.println(list.element());

    }

    static void testClone(){
        LinkedList list = new LinkedList(Arrays.asList(1, "111", null, new Object()));
        System.out.println(list);
        System.out.println((LinkedList)list.clone());

    }

    static void testToArray(){
        LinkedList list = new LinkedList(Arrays.asList(1));
        Integer[] test = {1, 2, 3, 4, 5, 6};
        Object[] objects = list.toArray(test);
        System.out.println(Arrays.toString(objects));
    }

    static void testTrySplit(){
        LinkedList list = new LinkedList(Arrays.asList(1, "111", null, new Object()));
        Spliterator spliterator = list.spliterator();
        list.spliterator();
        System.out.println(spliterator.estimateSize());
        spliterator.forEachRemaining((Object o)->{
            System.out.println(o);
        });
    }
}
