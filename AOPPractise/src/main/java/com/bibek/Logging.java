package com.bibek;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logging {

    @Before("execution(* com.bibek.ShoppingCart.shopping())")
    public void beforeLogger(){
        System.out.println("Before Logging");
    }

    @After("execution(* com.bibek.ShoppingCart.shopping())")
    public void afterLogger(){
        System.out.println("After Logging");
    }
}
