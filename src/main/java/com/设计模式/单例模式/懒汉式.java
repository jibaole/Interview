package com.设计模式.单例模式;

/**
 * @description：
 * @author：JBL
 * @date：2018/5/1
 */

public class 懒汉式 {
    private static 懒汉式 singleton;

    private 懒汉式() {}

    public static 懒汉式 getInstance() {
        if (singleton == null) {
            singleton = new 懒汉式();
        }
        return singleton;
    }
}
