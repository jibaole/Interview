package test;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * @description：生产者-消费者
 * @author：JBL
 * @date：2018/5/1
 */

public class ProducerConsumer {
    /**
     * 阻塞队列
     */
    LinkedBlockingQueue<Object> queue = new LinkedBlockingQueue<Object>(10);

    public ProducerConsumer(){
        new Producer().start();
        new Consumer().start();
    }

    /**
     * 生产者
     */
    class Producer extends Thread {
        @Override
        public void run(){
           while (true){
               double random = Math.random();
               try {
                   queue.put( random );
               }catch(Exception e){
                   System.out.println( "生产异常" );
               }
           }
        }
    }

    /**
     * 消费者
     */
    class Consumer extends Thread {
        @Override
        public void run(){
            while (true){
                try {
                    System.out.println( queue.take() );
                }catch(Exception e){
                    System.out.println( "消费异常" );
                }
            }
        }
    }

    public static void main(String[] args){
        new ProducerConsumer();
    }
}
