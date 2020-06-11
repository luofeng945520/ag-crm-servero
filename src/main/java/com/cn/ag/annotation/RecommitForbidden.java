package com.cn.ag.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface RecommitForbidden {
    /* 重复提交操作默认等待时间(30秒) */
    long waitingTime() default 30000;
}
