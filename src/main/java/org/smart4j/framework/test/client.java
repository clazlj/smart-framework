package org.smart4j.framework.test;

import org.smart4j.framework.spring.aop.GreetingBeforeAndAfterAdvice;
import org.smart4j.framework.test.service.Greeting;
import org.smart4j.framework.test.service.impl.GreetingImpl;
import org.springframework.aop.framework.ProxyFactory;

public class client {

    public static void main(String[] args) {
        //创建代理工厂
        ProxyFactory proxyFactory = new ProxyFactory();
        //射入目标对象
        proxyFactory.setTarget(new GreetingImpl());
        //添加前置增强、后置增强
        //如果前置、后置增强是两个类，而且都需要的话可以对两个类分别addAdvice
        proxyFactory.addAdvice(new GreetingBeforeAndAfterAdvice());

        Greeting greeting = (Greeting) proxyFactory.getProxy();
        greeting.sayHello("Jack");

    }
}
