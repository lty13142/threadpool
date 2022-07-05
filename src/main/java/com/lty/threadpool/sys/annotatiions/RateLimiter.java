package com.lty.threadpool.sys.annotatiions;

import com.lty.threadpool.sys.entity.enums.LimitType;

import java.lang.annotation.*;

/**
 * @author Tianyu
 * @date 2022/5/25 16:37
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RateLimiter {

    /**
     * 限流key
     */
    String key() default "rate_limit:";

    /**
     * 限流时间,单位秒
     */
    int time() default 60;

    /**
     * 限流次数
     */
    int count() default 100;

    /**
     * 限流类型
     */
    LimitType limitType() default LimitType.DEFAULT;

}
