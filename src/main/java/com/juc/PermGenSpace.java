package com.juc;

import java.util.Vector;

/**
 * @description��
 * @author��JBL
 * @date��2018/4/8
 */

public class PermGenSpace {
    public static void main(String[] args) {
        Vector v=new Vector(1000);
        for (int i=1;i<10000; i++ ) {
            Object o=new Object();
            v.add(o);
            o=null;
        }
        System.out.println(new double[1000000000]);
    }
}
