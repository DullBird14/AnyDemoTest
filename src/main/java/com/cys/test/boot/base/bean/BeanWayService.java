package com.cys.test.boot.base.bean;

class BeanWayService {

    void init(){
        System.out.println("bean at init!");
    }

    BeanWayService(){
        super();
        System.out.println("bean 初始化构造函数");
    }

    void destory(){
        System.out.println("bean destory");
    }
}
