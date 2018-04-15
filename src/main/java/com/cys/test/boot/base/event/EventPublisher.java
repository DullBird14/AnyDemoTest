package com.cys.test.boot.base.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

public class EventPublisher {
    @Autowired
    ApplicationContext context;

    public void publisher(String msg){
        context.publishEvent(new EventBean(this, msg));
    }
}
