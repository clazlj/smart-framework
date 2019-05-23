package org.smart4j.framework;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * JDK动态代理
 * 限制：使用动态代理的对象必须实现一个或多个接口
 */
public class DynamicProxy implements InvocationHandler {
    /**
     * 被代理的目标对象
     * 通过构造函数来初始化(注入)
     */
    private Object target;

    public DynamicProxy(Object target) {
        this.target = target;
    }

    /**
     * 三个参数由JRE”射“进来
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();

        Object result = method.invoke(target, args);

        after();

        return result;
    }

    private void before() {
        System.out.println("Before");
    }

    private void after() {
        System.out.println("After");
    }

    @SuppressWarnings("unchecked")
    public <T> T getProxy() {
        return (T) Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                this
        );
    }
}
