package com.cys.boot.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.cys.test.boot.aop")
@EnableAspectJAutoProxy
public class AopConfig {
}
