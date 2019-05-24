package org.smart4j.framework.annotation;

import java.lang.annotation.*;

/**
 * ElementType.TYPE：只能用在类上
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Aspect {
    /**
     * 注解
     */
    Class<? extends Annotation> value();
}
