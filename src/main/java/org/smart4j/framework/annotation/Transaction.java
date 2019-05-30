package org.smart4j.framework.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * 定义需要事务控制的方法
 * Target被限定为只能用于方法级别
 */
@Target(ElementType.METHOD)
public @interface Transaction {
}
