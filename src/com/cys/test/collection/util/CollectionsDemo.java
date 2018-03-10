package com.cys.test.collection.util;

import com.sun.org.apache.xpath.internal.operations.String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CollectionsDemo {
    private static Integer[] intArray = new Integer[]{1, 2, 3, 100, 123, 533, 56, 89};
    static {
        System.out.println(Arrays.toString(intArray));
    }

    /**
     * 测试方法
     */
    public static void testOne(){
        List<Integer> integers = Arrays.asList(intArray);
//        Collections.sort(integers);//按顺序排
//        Collections.shuffle(integers);//混排
//        Collections.reverse(integers);//反转
//        Collections.fill(integers, 0);//用0填充数组
        /*
        List<Integer> copyList = new ArrayList<Integer>();
        for (int i = 0; i <= 9; i++) {
            copyList.add(0);
        }
        System.out.println(copyList.size());
        Collections.copy(copyList, integers);//A,B参数从B复制到A，但是A的size要比B的大，初始化出来的size为0
        System.out.println(copyList);
        */
//        Collections.indexOfSubList(integers, new ArrayList<Integer>(){{
//            this.add(3);
//        }});//字串所在的位置
    //        Collections.max(integers)//最大最小值
//        Collections.rotate(integers, 1);//根据传入的数字，整体移动集合，负数为往前移动
        System.out.println(Collections.binarySearch(integers, 56));//二分法查找，集合必须先排好序,否则返回值有问题
//        System.out.println(Collections.rotate(integers, 1));
        System.out.println(integers);
    }

    public static void main(String[] args) {
        CollectionsDemo.testOne();
    }
}
