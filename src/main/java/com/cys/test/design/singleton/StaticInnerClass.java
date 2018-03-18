package com.cys.test.design.singleton;

public class StaticInnerClass {
    private StaticInnerClass(){

    }

    private static class InnerClass{
        private static StaticInnerClass A = new StaticInnerClass();
    }

    public static StaticInnerClass getInstance(){
        return InnerClass.A;
    }
    public static void main(String[] args) {
        StaticInnerClass.getInstance();
//        System.out.println(11111111);
    }
}
