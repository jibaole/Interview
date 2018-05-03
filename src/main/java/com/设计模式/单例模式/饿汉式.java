package com.设计模式.单例模式;

/**
 * @description：
 * @author：JBL
 * @date：2018/5/1
 */

public class 饿汉式 {
    private final static 饿汉式 INSTANCE = new 饿汉式();

    private 饿汉式(){}

    public static 饿汉式 getInstance(){
        return INSTANCE;
    }
}
