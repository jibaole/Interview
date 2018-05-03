package com.设计模式.单例模式;

/**
 * @description：
 * @author：JBL
 * @date：2018/5/1
 */

public class 静态内部类 {

        private 静态内部类() {}

        private static class SingletonInstance {
            private static final 静态内部类 INSTANCE = new 静态内部类();
        }

        public static 静态内部类 getInstance() {
            return SingletonInstance.INSTANCE;
        }
    }


