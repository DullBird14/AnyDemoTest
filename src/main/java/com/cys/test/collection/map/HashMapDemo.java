package com.cys.test.collection.map;

import java.util.HashMap;
import java.util.Iterator;

/**
 *  疑问继承类AbstractMap并且实现了map接口,但是AbstractMap已经实现了map接口
 *  可能是为了方便替换继承类
 *  1.初始化容量为16,能力因子是0.75，阀值是16*0.75 = 9.
 *  即当大于元素将大于9的时候进行扩容，扩容一倍，并且需要重新计算所有元素的位置。
 *  2.map的结构是 Entry数组+数组的元素的Entry,当hash计算重复的时候，可以实现链表结构。
 *
 */
public class HashMapDemo {
    public static void main(String[] args) {
        Country india=new Country("India",1000);
        Country japan=new Country("Japan",10000);

        Country france=new Country("France",2000);
        Country russia=new Country("Russia",20000);

        HashMap<Country, String> countryCapitalMap=new HashMap<Country, String>();
        countryCapitalMap.put(india, "Delhi");
        countryCapitalMap.put(japan, "Tokyo");
        countryCapitalMap.put(france, "Paris");
        countryCapitalMap.put(russia, "Moscow");

        Iterator<Country> countryCapitalIter=countryCapitalMap.keySet().iterator();//put debug point at this line
        while (countryCapitalIter.hasNext()) {
            Country countryObj=countryCapitalIter.next();
            String capital=countryCapitalMap.get(countryObj);
            System.out.println(countryObj.getName()+"----"+capital);
        }
    }
}
