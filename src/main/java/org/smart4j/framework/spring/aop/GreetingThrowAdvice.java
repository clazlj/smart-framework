package org.smart4j.framework.spring.aop;

import org.springframework.aop.ThrowsAdvice;

import java.lang.reflect.Method;

/**
 * 抛出增强类
 */
public class GreetingThrowAdvice implements ThrowsAdvice {
    //接口上没有任何方法，但是实现了这个接口的类必须至少实现以下4个方法中的一个
    //1 public void afterThrowing(Exception ex)
    //2 public void afterThrowing(RemoteException)
    //3 public void afterThrowing(Method method, Object[] args, Object target, Exception ex)
    //4 public void afterThrowing(Method method, Object[] args, Object target, ServletException ex)

    public void afterThrowing(Method method, Object[] args, Object target, Exception ex) {
        System.out.println("------- Throw Exception -------");
        System.out.println("Target Class:" + target.getClass().getName());
        System.out.println("Method Name:" + method.getName());
        System.out.println("Exception Message:" + ex.getMessage());
        System.out.println("-------------------------------");
    }
}
