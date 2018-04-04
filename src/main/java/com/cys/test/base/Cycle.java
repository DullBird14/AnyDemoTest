package com.cys.test.base;

import java.util.Map;

public class Cycle {

    public void test(){
        move(3, "A", "B", "C");
    }

    private void move(int level, String a, String b, String c){
        if(level >0){
            move(level-1, a, c, b);
            System.out.println(a + "---》" + b + "\r\n");
            move(level-1, c, b, a);
        }
    }

    public static void main(String[] args) {
        Cycle c = new Cycle();
        c.test();
    }
}
