package com.���ģʽ;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * @description��������������ģʽ
 * @author��JBL
 * @date��2018/5/1
 * @Url:https://www.cnblogs.com/happyPawpaw/archive/2013/01/18/2865957.html
 */

public class ProducerConsumer {
    /**
     * ����һ����������
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
                    // ����һ������
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
                    // ȡ��һ������
                    System.out.println("Consumer: " + queue.take());
                } catch (InterruptedException e) {
                    System.out.println("producer is interrupted!");
                }
            }
        }
    }

}
