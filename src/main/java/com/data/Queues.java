package com.data;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @description������
 * �ο���ַ��http://www.runoob.com/java/data-queue.html
 * @author��JBL
 * @date��2018/4/13
 */

public class Queues {

    public static void main(String[] args) {
        //add()��remove()������ʧ�ܵ�ʱ����׳��쳣(���Ƽ�)
        Queue<String> queue = new LinkedList<String>();
        //���Ԫ��
        queue.offer( "a" );
        queue.offer( "b" );
        queue.offer( "c" );
        queue.offer( "d" );
        queue.offer( "e" );
        System.out.println( "----------�Ƚ��ȳ�----------" );
        for (String q : queue) {
            System.out.println( q );
        }


        System.out.println( "----------���ص�һ��Ԫ�أ����ڶ�����ɾ��----------" );
        System.out.println( "poll=" + queue.poll() );
        for (String q : queue) {
            System.out.println( q );
        }

        System.out.println( "----------���ص�һ��Ԫ��----------" );
        System.out.println( "element=" + queue.element() );
        for (String q : queue) {
            System.out.println( q );
        }

        System.out.println( "----------���ص�һ��Ԫ��----------" );
        System.out.println( "peek=" + queue.peek() );
        for (String q : queue) {
            System.out.println( q );
        }
    }
}
