package com.cys.test.design.combine;

public class Leaf implements  ComponentInterface {
    private String name;

    Leaf(String name){
        this.name = name;
    }
    @Override
    public void add(ComponentInterface temp) {
        System.out.println("not support!");
        return;
    }

    @Override
    public void remove(ComponentInterface temp) {
        System.out.println("not support!");
        return;
    }

    @Override
    public void list() {
        System.out.println(name);
    }
}
