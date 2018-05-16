package com.cys.test.base;

import java.io.FileNotFoundException;

/**
 * 1.一定要先继承后实现
 * 2.throws可以在方法体抛出任何异常
 * 3.final方法可以重载
 */
public class ExtendsTest  {
    public final void test() throws NullPointerException, FileNotFoundException {
    }

    public void test(String a) {

    }
}
