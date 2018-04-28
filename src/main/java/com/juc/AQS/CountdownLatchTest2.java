package com.juc.AQS;

import java.util.concurrent.CountDownLatch;
/**
 * @description：百米赛跑，4名运动员选手到达场地等待裁判口令，裁判一声口令，选手听到后同时起跑，当所有选手到达终点，裁判进行汇总汇总排名。
 * @author：JBL
 * @date：2018/4/13
 */

public class CountdownLatchTest2 {

    public static void main(String[] args) {

        final CountDownLatch cdOrder = new CountDownLatch( 1 );
        final CountDownLatch cdAnswer = new CountDownLatch( 4 );
        for (int i = 0; i < 4; i++) {
            new Thread( new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println( "选手" + Thread.currentThread().getName() + "正等待裁判发布口令" );
                        cdOrder.await();
                        System.out.println( "选手" + Thread.currentThread().getName() + "已接受裁判口令" );
                        Thread.sleep( (long) (Math.random() * 10000) );
                        System.out.println( "选手" + Thread.currentThread().getName() + "到达终点" );
                        cdAnswer.countDown();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();

        }
        try {
            Thread.sleep( (long) (Math.random() * 10000) );

            System.out.println( "裁判" + Thread.currentThread().getName() + "即将发布口令" );
            cdOrder.countDown();
            System.out.println( "裁判" + Thread.currentThread().getName() + "已发送口令，正在等待所有选手到达终点" );
            cdAnswer.await();
            System.out.println( "所有选手都到达终点" );
            System.out.println( "裁判" + Thread.currentThread().getName() + "汇总成绩排名" );
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
