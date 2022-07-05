package com.lty.threadpool.sys.entity.enums;

/**
 * @author Tianyu
 * @date 2022/5/25 16:36
 */
public enum LimitType {

    /**
     * 默认策略全局限流
     */
    DEFAULT,
    /**
     * 根据请求者IP进行限流
     */
    IP

}
