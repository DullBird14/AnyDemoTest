package com.cys.test.boot.base.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.cys.test.boot.base.bean")
class BeanConfig {
    @Bean(initMethod = "init", destroyMethod = "destory")
    BeanWayService beanWayService(){
        return new BeanWayService();
    }
}
