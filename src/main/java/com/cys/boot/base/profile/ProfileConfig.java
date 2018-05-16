package com.cys.boot.base.profile;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@ComponentScan("com.cys.test.boot.base.profile")
public class ProfileConfig {
    @Bean
    @Profile("dev")
    public DemoBean DemoBean(){
        return new DemoBean();
    }

    @Bean
    @Profile("prod")
    public DemoDevBean DemoDevBean(){
        return new DemoDevBean();
    }
}
