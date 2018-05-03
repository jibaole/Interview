package com.设计模式;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * @description：生产者消费者模式
 * @author：JBL
 * @date：2018/5/1
 * @Url:https://www.cnblogs.com/happyPawpaw/archive/2013/01/18/2865957.html
 */

public class ProducerConsumer {
    /**
     * 建立一个阻塞队列
     */
    private LinkedBlockingQueue<Object> queue = new LinkedBlockingQueue<Object>(10);

    public ProducerConsumer() {
        new Producer().start();
        new Consumer().start();
    }



    public static void main(String[] args) throws Exception {
        new ProducerConsumer();
    }

    class Producer extends Thread {
        @Override
        public void run() {
            while (true) {
                try {
                    Object o = new Object();
                    // 放入一个对象
                    queue.put(o);
                    System.out.println("Producer: " + o);
                } catch (InterruptedException e) {
                    System.out.println("producer is interrupted!");
                }
            }
        }
    }

    class Consumer extends Thread {
        @Override
        public void run() {
            while (true) {
                try {
                    // 取出一个对象
                    System.out.println("Consumer: " + queue.take());
                } catch (InterruptedException e) {
                    System.out.println("producer is interrupted!");
                }
            }
        }
    }

}
