package com.juc.forkjoin;

/**
 * @description��
 * @author��JBL
 * @date��2018/4/17
 */

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * forkjoin�ļ�����
 * Created by wenbronk on 2017/7/26.
 */
public class CountTask extends RecursiveTask<Integer> {
    private volatile static int count = 0;
    private int start;
    private int end;

    public CountTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public static final int threadhold = 2;

    @Override
    protected Integer compute() {
        int sum = 0;
        System.out.println("������һ���̵߳�����: " + count++);
        // ��������㹻С, ��ֱ��ִ��
        boolean canCompute = (end - start) <= threadhold;
        if (canCompute) {
            for (int i = start; i <= end; i++) {
                sum += i;
            }
        }else {
            //���������ֵ, ����Ϊ2������
            int middle = (start + end) / 2;
            CountTask countTask1 = new CountTask(start, middle);
            CountTask countTask2 = new CountTask(middle + 1, end);

            // �����߳�
//            countTask1.fork();
//            countTask2.fork();
            invokeAll(countTask1, countTask2);

            Integer join1 = countTask1.join();
            Integer join2 = countTask2.join();

            // ����ϲ�
            sum = join1 + join2;
        }
        return sum;
    }


    // ����
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ForkJoinPool forkJoinPool = new ForkJoinPool();

        CountTask countTask = new CountTask(1, 100);
        ForkJoinTask<Integer> result = forkJoinPool.submit(countTask);
        System.out.println(result.get());
    }
}