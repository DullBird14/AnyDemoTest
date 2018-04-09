package com.cys.test.boot.aop;

import java.lang.reflect.Method;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {
    @Pointcut("@annotation(com.cys.test.boot.aop.Action)")
    void annotationPointCut(){};

    @After("annotationPointCut()")
    public void after(JoinPoint point) {
        MethodSignature methodSignature = (MethodSignature) point.getSignature();
        Method method = methodSignature.getMethod();
        Action action = method.getAnnotation(Action.class);
        System.out.println("注解aop :" + action.name());
    }

    @Before("execution(* com.cys.test.boot.aop.DemoMethodService.*(..))")
    public void before(JoinPoint point){
        MethodSignature methodSignature = (MethodSignature)point.getSignature();
        Method method = methodSignature.getMethod();
        System.out.println("方法拦截，" + method.getName());
    }
}
