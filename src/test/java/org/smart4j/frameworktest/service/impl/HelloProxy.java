package org.smart4j.frameworktest.service.impl;

import org.smart4j.frameworktest.service.Hello;

/**
 * 静态代理demo
 * 不用我去做，别人代替我去处理
 */
public class HelloProxy implements Hello {
    private Hello hello;

    public HelloProxy() {
        hello = new HelloImpl();
    }

    @Override
    public void say(String name) {
        before();
        hello.say(name);
        after();
    }


    private void before() {
        System.out.println("Before");
    }

    private void after() {
        System.out.println("After");
    }
}
