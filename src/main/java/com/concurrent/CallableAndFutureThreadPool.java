package com.concurrent;

import java.util.Random;
import java.util.concurrent.*;

/**
 * @description：
 * @author：JBL
 * @date：2018/4/8
 */

public class CallableAndFutureThreadPool {
    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newSingleThreadExecutor();
        Future<Integer> future = threadPool.submit( new Callable<Integer>() {
            public Integer call() throws Exception {
                return new Random().nextInt(100);
            }
        });
        try {
            // 可能做一些事情
            Thread.sleep(5000);
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
