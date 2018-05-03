package com.设计模式.单例模式;

/**
 * @description：
 * @author：JBL
 * @date：2018/5/1
 */

public class 双重检查 {
    private static volatile 双重检查 singleton;

    private 双重检查() {}

    public static 双重检查 getInstance() {
        if (singleton == null) {
            synchronized (双重检查.class) {
                if (singleton == null) {
                    singleton = new 双重检查();
                }
            }
        }
        return singleton;
    }
}
