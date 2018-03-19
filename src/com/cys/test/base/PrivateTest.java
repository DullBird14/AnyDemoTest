package com.cys.test.base;

import java.util.Date;

public class PrivateTest extends Date {


    private void play(){
        System.out.println(super.getClass().getName());
    }

    public static void main(String[] args) {
        PrivateTest test = new PrivateTest();
        test.play();
    }
}
