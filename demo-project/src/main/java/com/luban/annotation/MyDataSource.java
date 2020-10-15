package com.luban.annotation;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface MyDataSource {
    //默认链接的是主库
    String value() default "master";
}
