package com.Sample.redis;

import utils.RedisUtils;

/**
 * @description£º
 * @author£ºJBL
 * @date£º2018/4/19
 */

public class writeTest  extends Thread {

    public writeTest(String s) {
        super(s);
    }

    @Override
    public void run() {
        RedisUtils ru = new RedisUtils();
        while (true) {
            try {
                String s = ru.set("test", "100");
                System.out.println(getName() + "===" + "done");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            String threadName = "WThread" + i;
            new writeTest(threadName).start();
        }
    }
}
