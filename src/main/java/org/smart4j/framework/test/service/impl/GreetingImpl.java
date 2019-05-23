package org.smart4j.framework.test.service.impl;

import org.smart4j.framework.test.service.Greeting;

public class GreetingImpl implements Greeting {
    @Override
    public void sayHello(String name) {
        System.out.println(name);

    }
}
