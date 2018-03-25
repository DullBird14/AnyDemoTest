package com.cys.test.design.combine;

import java.util.ArrayList;
import java.util.List;

public class Container implements ComponentInterface {

    private String name;

    private List<ComponentInterface> folder = new ArrayList<>();
    Container(String name){
        this.name = name;
    }
    @Override
    public void add(ComponentInterface temp) {
        folder.add(temp);
    }

    @Override
    public void remove(ComponentInterface temp) {
        folder.remove(temp);
    }

    @Override
    public void list() {
        System.out.println("打开folder：" + name );
        for (ComponentInterface componentInterface : folder) {
            componentInterface.list();
        }
    }
}
