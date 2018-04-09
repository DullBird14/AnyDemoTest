package com.cys.test.boot.aop;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
//需要注意是@interface而不是interface
@interface Action {
    String name();
}
