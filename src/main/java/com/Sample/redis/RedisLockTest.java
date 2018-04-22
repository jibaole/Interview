package com.Sample.redis;

import utils.RedisUtils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @description：
 * @author：JBL
 * @date：2018/4/19
 */

public class RedisLockTest {

    /**
     * 线程工厂,命名线程
     */
    public static class MyThreadFactory implements ThreadFactory {
        public static AtomicInteger count = new AtomicInteger();
        @Override
        public Thread newThread(Runnable r) {
            count.getAndIncrement();
            Thread thread = new Thread(r);
            thread.setName("Thread-lock-test "+count);
            return thread;
        }
    }

    public static void main(String[] args) {
        final String key = "test1";
        Runnable task = () ->{
            RedisUtils testCli = new RedisUtils();
            testCli.setLockExpirseTime( 20 );
            String value = testCli.lock(key);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            testCli.unLock(key,value);
        };

        MyThreadFactory factory = new MyThreadFactory();
        ExecutorService services = Executors.newFixedThreadPool(10);
        Executors.newCachedThreadPool();
        Executors.newFixedThreadPool( 10 );
        Executors.newScheduledThreadPool( 11 );
        for (int i = 0;i<10;i++) {
            services.execute( factory.newThread( task ) );
        }
    }


}
