package com.cys.test.design.combine;

public class Main {
    public static void main(String[] args) {
        Container first = new Container("第一层");
        Container second = new Container("第二层");
        first.add(new Leaf("A"));
        first.add(second);
        second.add(new Leaf("B"));
        second.add(new Leaf("C"));
        first.list();
    }
}
