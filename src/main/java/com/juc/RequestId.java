package com.juc;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @description£º
 * @author£ºJBL
 * @date£º2018/4/8
 */

public class RequestId {
    private static final AtomicLong idGenerator = new AtomicLong( 1 );



    public static long getRequestId() {
        return idGenerator.getAndIncrement();
    }

    public static void main(String[] args) {
        for(int i=1;i<1000;i++){
            System.out.println(i+"¡ª¡ª>"+ getRequestId() );
        }

    }
}
