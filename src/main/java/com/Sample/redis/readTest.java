package com.Sample.redis;

import utils.RedisUtils;

/**
 * @description£º
 * @author£ºJBL
 * @date£º2018/4/19
 */

public class readTest extends Thread {

    public readTest(String s) {
            super(s);
        }

    @Override
    public void run() {
        RedisUtils ru = new RedisUtils();
        while (true) {
            try {
                String s = ru.get("test");
                System.out.println(getName() + "===" + s);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            String threadName = "RThread" + i;
            new readTest(threadName).start();
        }
    }
}
