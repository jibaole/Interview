package test;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * @description��������-������
 * @author��JBL
 * @date��2018/5/1
 */

public class ProducerConsumer {
    /**
     * ��������
     */
    LinkedBlockingQueue<Object> queue = new LinkedBlockingQueue<Object>(10);

    public ProducerConsumer(){
        new Producer().start();
        new Consumer().start();
    }

    /**
     * ������
     */
    class Producer extends Thread {
        @Override
        public void run(){
           while (true){
               double random = Math.random();
               try {
                   queue.put( random );
               }catch(Exception e){
                   System.out.println( "�����쳣" );
               }
           }
        }
    }

    /**
     * ������
     */
    class Consumer extends Thread {
        @Override
        public void run(){
            while (true){
                try {
                    System.out.println( queue.take() );
                }catch(Exception e){
                    System.out.println( "�����쳣" );
                }
            }
        }
    }

    public static void main(String[] args){
        new ProducerConsumer();
    }
}
