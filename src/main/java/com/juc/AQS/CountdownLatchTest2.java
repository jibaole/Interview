package com.juc.AQS;

import java.util.concurrent.CountDownLatch;
/**
 * @description���������ܣ�4���˶�Աѡ�ֵ��ﳡ�صȴ����п������һ�����ѡ��������ͬʱ���ܣ�������ѡ�ֵ����յ㣬���н��л��ܻ���������
 * @author��JBL
 * @date��2018/4/13
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
                        System.out.println( "ѡ��" + Thread.currentThread().getName() + "���ȴ����з�������" );
                        cdOrder.await();
                        System.out.println( "ѡ��" + Thread.currentThread().getName() + "�ѽ��ܲ��п���" );
                        Thread.sleep( (long) (Math.random() * 10000) );
                        System.out.println( "ѡ��" + Thread.currentThread().getName() + "�����յ�" );
                        cdAnswer.countDown();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();

        }
        try {
            Thread.sleep( (long) (Math.random() * 10000) );

            System.out.println( "����" + Thread.currentThread().getName() + "������������" );
            cdOrder.countDown();
            System.out.println( "����" + Thread.currentThread().getName() + "�ѷ��Ϳ�����ڵȴ�����ѡ�ֵ����յ�" );
            cdAnswer.await();
            System.out.println( "����ѡ�ֶ������յ�" );
            System.out.println( "����" + Thread.currentThread().getName() + "���ܳɼ�����" );
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
