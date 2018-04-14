package com.data;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @description：队列
 * 参考地址：http://www.runoob.com/java/data-queue.html
 * @author：JBL
 * @date：2018/4/13
 */

public class Queues {

    public static void main(String[] args) {
        //add()和remove()方法在失败的时候会抛出异常(不推荐)
        Queue<String> queue = new LinkedList<String>();
        //添加元素
        queue.offer( "a" );
        queue.offer( "b" );
        queue.offer( "c" );
        queue.offer( "d" );
        queue.offer( "e" );
        System.out.println( "----------先进先出----------" );
        for (String q : queue) {
            System.out.println( q );
        }


        System.out.println( "----------返回第一个元素，并在队列中删除----------" );
        System.out.println( "poll=" + queue.poll() );
        for (String q : queue) {
            System.out.println( q );
        }

        System.out.println( "----------返回第一个元素----------" );
        System.out.println( "element=" + queue.element() );
        for (String q : queue) {
            System.out.println( q );
        }

        System.out.println( "----------返回第一个元素----------" );
        System.out.println( "peek=" + queue.peek() );
        for (String q : queue) {
            System.out.println( q );
        }
    }
}
