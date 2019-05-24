package org.smart4j.framework.proxy;

/**
 * 执行链式代理
 */
public interface Proxy {
    Object doProxy(ProxyChain proxyChain) throws Throwable;
}
