package org.smart4j.framework.test;

import org.smart4j.framework.spring.aop.GreetingArroundAdvice;
import org.smart4j.framework.spring.aop.GreetingBeforeAndAfterAdvice;
import org.smart4j.framework.spring.aop.GreetingThrowAdvice;
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
        GreetingBeforeAndAfterAdvice greetingBeforeAndAfterAdvice = new GreetingBeforeAndAfterAdvice();
        proxyFactory.addAdvice(greetingBeforeAndAfterAdvice);

        //Greeting greeting = (Greeting) proxyFactory.getProxy();
        //greeting.sayHello("Jack");

        //移除之前的前置增强、后置增强。
        //proxyFactory.removeAdvice(greetingBeforeAndAfterAdvice);
        //新增环绕增强
        proxyFactory.addAdvice(new GreetingArroundAdvice());
        //greeting = (Greeting) proxyFactory.getProxy();
        //greeting.sayHello("LinTao");

        proxyFactory.addAdvice(new GreetingThrowAdvice());
        Greeting greeting = (Greeting) proxyFactory.getProxy();
        greeting.sayHello("Tom");
    }
}
