package com.concurrent.future;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @description��
 * @author��JBL
 * @date��2018/4/17
 */

public class FutureCook {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        long startTime = System.currentTimeMillis();
        // ��һ�� ��������
        Callable<Chuju> onlineShopping = new Callable<Chuju>() {

            @Override
            public Chuju call() throws Exception {
                System.out.println( "��һ�����µ�" );
                System.out.println( "��һ�����ȴ��ͻ�" );
                // ģ���ͻ�ʱ��
                Thread.sleep( 3000 );
                System.out.println( "��һ��������͵�" );
                return new Chuju();
            }

        };
        FutureTask<Chuju> task = new FutureTask<Chuju>( onlineShopping );
        new Thread( task ).start();
        // �ڶ��� ȥ���й���ʳ��
        // ģ�⹺��ʳ��ʱ��
        Thread.sleep( 2000 );
        Shicai shicai = new Shicai();
        System.out.println( "�ڶ�����ʳ�ĵ�λ" );
        // ������ �ó������ʳ��
        // ��ϵ���Ա��ѯ���Ƿ񵽻�
        System.out.println("wwwwwww:"+task.isDone());
        if (!task.isDone()) {
            System.out.println( "�����������߻�û��������þ͵��ţ����鲻�þ͵���cancel����ȡ��������" );
        }
        Chuju chuju = task.get();
        System.out.println( "�����������ߵ�λ����ʼչ�ֳ���" );
        cook( chuju, shicai );

        System.out.println( "�ܹ���ʱ" + (System.currentTimeMillis() - startTime) + "ms" );
    }

    //  �ó������ʳ��
    static void cook(Chuju chuju, Shicai shicai) {
    }

    // ������
    static class Chuju {
    }

    // ʳ����
    static class Shicai {
    }

}