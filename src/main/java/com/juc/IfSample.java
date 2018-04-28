package com.juc;

/**
 * @description£º
 * @author£ºJBL
 * @date£º2018/3/13
 */

public class IfSample {
    public static void main(String[] args) {
        int i = 0;
        for (i = 3, --i; i > 0; System.out.println( --i )) {
            System.out.println( i );
        }


    }
}
