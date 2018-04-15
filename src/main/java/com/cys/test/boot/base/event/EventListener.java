package com.cys.test.boot.base.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class EventListener implements ApplicationListener<EventBean> {

    @Override
    public void onApplicationEvent(EventBean event) {
        System.out.println("我是EventListener,收到了信息" + event.getMsg());
    }
}
