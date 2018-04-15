package com.cys.test.boot.base.event;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.cys.test.boot.base.event")
public class EventConfig {

    @Bean
    EventPublisher eventPublisher(){
        return new EventPublisher();
    }
}
