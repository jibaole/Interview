package com.cmd;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @description��
 * @author��JBL
 * @date��2018/4/22
 */

class TestTask implements Runnable {
    @Override
    public void run() {

        synchronized (this) {
            try {
                //�ȴ�������
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }




    public static void main(String[] args) throws InterruptedException {

        ExecutorService ex = Executors.newFixedThreadPool(1);
        ex.execute(new TestTask());

    }
}