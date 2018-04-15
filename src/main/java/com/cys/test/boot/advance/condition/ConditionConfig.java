package com.cys.test.boot.advance.condition;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

@Configuration
public class ConditionConfig {
    @Bean
    @Conditional(WindowsCondition.class)
    public ConditionService windowsService(){
        return new WindowsService();
    }

    @Bean
    @Conditional(LinuxCondition.class)
    public ConditionService linuxService(){
        return new LinuxService();
    }
}
