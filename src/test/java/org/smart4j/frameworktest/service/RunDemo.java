package org.smart4j.frameworktest.service;

import org.smart4j.framework.CglibProxy;
import org.smart4j.framework.DynamicProxy;
import org.smart4j.frameworktest.service.impl.HelloImpl;
import org.smart4j.frameworktest.service.impl.HelloProxy;

public class RunDemo {

    public static void main(String[] args) {
        //静态代理
        Hello helloProxy = new HelloProxy();
        helloProxy.say("Jack");

        //JDK动态代理
        DynamicProxy dynamicProxy = new DynamicProxy(new HelloImpl());
        helloProxy = dynamicProxy.getProxy();
        helloProxy.say("Tom");

        //CgLib动态代理
        //CglibProxy cglibProxy = new CglibProxy();用单例代替
        helloProxy = CglibProxy.getInstance().getProxy(HelloImpl.class);
        helloProxy.say("Helen");

    }
}
