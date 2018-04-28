package com.juc;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @description��
 * @author��JBL
 * @date��2018/3/11
 */

public class ThreadLocalSample {
    /*������1��ThreadLocal<Integer>����
     *����д����initialValue��������ʼֵ��3*/
    private ThreadLocal<Integer> tlA = new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue(){
            return 3;
        }
    };


    /**����һ���ź����������Ϊ1���������߳�˳��ִ��*/
    Semaphore semaphore = new Semaphore(1);

    private Random rnd = new Random();

    /**Worker����Ϊ�ڲ���ʵ����Runnable�ӿ�,tlA�������ⲿ���У�
ÿ���߳��е�����������get�������ٵ���һ��set��������һ�����ֵ*/
    public class Worker implements Runnable{
        @Override
        public void run(){

            try {
                /**�����ʱ1s���ڵ�ʱ��*/
                Thread.sleep(rnd.nextInt(1000));
                semaphore.acquire();/*��ȡ���*/
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            int valA = tlA.get();
            System.out.println(Thread.currentThread().getName() +" tlA initial val : "+ valA);
            valA = rnd.nextInt();
            tlA.set(valA);
            System.out.println(Thread.currentThread().getName() +" tlA  new     val: "+ valA);

            /**int valB = tlB.get();
            System.out.println(Thread.currentThread().getName() +" tlB initial val : "+ valB);
            valB = rnd.nextInt();
            tlA.set(valB);
            System.out.println(Thread.currentThread().getName() +" tlB 2    new val: "+ valB)*/

            semaphore.release();

            /*���̳߳���,���߳��˳�֮ǰһ��Ҫ�ǵõ���remove��������Ϊ���̳߳��е��̶߳�����ѭ��ʹ�õ�*/
            tlA.remove();
            /*tlB.remove();*/
        }
    }

    /**���������̣߳�ÿ���̶߳����ThreadLocal����tlA���в���*/
    public static void main(String[] args){

        ExecutorService es = Executors.newFixedThreadPool(3);
        ThreadLocalSample tld = new ThreadLocalSample();
        es.execute(tld.new Worker());
        es.execute(tld.new Worker());
        es.execute(tld.new Worker());
        es.shutdown();
    }
}