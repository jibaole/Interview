package com.thread;

import java.util.concurrent.CountDownLatch;

/**
 * @description��
 * @author��JBL
 * @date��2018/4/13
 */

public class CountDownLatchSample {

    public static void CountDownLatch(int threadCount) {
        Long start = System.currentTimeMillis();
        final CountDownLatch latch = new CountDownLatch( threadCount );
        for (int i = 0; i < threadCount; i++) {
            new Thread( new Runnable() {
                @Override
                public void run() {
                    System.out.println( "�߳�" + Thread.currentThread().getId() + "��ʼ����" );
                    try {
                        Thread.sleep( 1000 );
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println( "�߳�" + Thread.currentThread().getId() + "�ѵ����յ�" );
                    latch.countDown();
                }
            } ).start();
        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Long end = System.currentTimeMillis();
        System.out.println( "10���߳��Ѿ�ִ�����! ����ʱ:"+(end-start) );
    }

    public static void main(String[] args) {
        CountDownLatch(10);
    }
}
