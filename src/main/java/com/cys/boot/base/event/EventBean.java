package com.cys.boot.base.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.Bean;

public class EventBean extends ApplicationEvent {
    private String message;
    /**
     * Create a new ApplicationEvent.
     *
     * @param source the component that published the event (never {@code null})
     */
    public EventBean(Object source, String msg) {
        super(source);
        this.message = msg;
    }


    String getMsg(){
        return message;
    }




}
