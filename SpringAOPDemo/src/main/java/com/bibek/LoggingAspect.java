package com.bibek;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* com.bibek.ShoppingCart.checkout(..))")
    public void beforelogger(){
        System.out.println("Before Logger");
    }

    @After("execution(* com.bibek.ShoppingCart.checkout(..))")
    public void afterLogger(){
        System.out.println("After Logger");
    }
}
