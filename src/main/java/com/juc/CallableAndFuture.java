package com.juc;

import java.util.concurrent.*;

/**
 * @description��
 * @author��JBL
 * @date��2018/4/8
 */

public class CallableAndFuture {
    public volatile int inc = 0;

  public  static void main(String[] args) {
       /* ExecutorService executor = Executors.newCachedThreadPool();
        Task task = new Task();
        Future<Integer> result = executor.submit( task );
      System.out.println(result.isDone());
        executor.shutdown();
      System.out.println(result.isDone());*/

      //��һ�ַ�ʽ
      ExecutorService executor = Executors.newCachedThreadPool();
      Task task = new Task();
      FutureTask<Integer> futureTask = new FutureTask<Integer>(task);
      executor.submit(futureTask);
      executor.shutdown();

      //�ڶ��ַ�ʽ��ע�����ַ�ʽ�͵�һ�ַ�ʽЧ�������Ƶģ�ֻ����һ��ʹ�õ���ExecutorService��һ��ʹ�õ���Thread
        /*Task task = new Task();
        FutureTask<Integer> futureTask = new FutureTask<Integer>(task);
        Thread thread = new Thread(futureTask);
        thread.start();*/


        try {
            Thread.sleep( 1000 );
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }

        System.out.println( "���߳���ִ������" );

        try {
            System.out.println( "task���н��" + futureTask.get() );
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println( "��������ִ�����" );
    }
}

class Task implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println( "���߳��ڽ��м���" );
        Thread.sleep( 3000 );
        int sum = 0;
        for (int i = 0; i < 100; i++)
            sum += i;
        return sum;
    }
}
