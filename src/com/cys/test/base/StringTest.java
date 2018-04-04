package com.cys.test.base;

/**
 * -Xmx5m -XX:+PrintGCDetails
 */
public class StringTest {
    public static void main(String[] args) {
        String a = System.currentTimeMillis()+"";
        while (true) {
            a = null;
            a = System.currentTimeMillis() + "" + new byte[1024];
//            System.out.println(a + "\r\n");
//            System.gc();
        }
    }
}
