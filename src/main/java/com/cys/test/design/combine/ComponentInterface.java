package com.cys.test.design.combine;

public interface ComponentInterface {
    void add(ComponentInterface temp);
    void remove(ComponentInterface temp);
    void list();
}
