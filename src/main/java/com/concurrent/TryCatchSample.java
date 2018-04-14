package com.concurrent;

/**
 * @description£º
 * @author£ºJBL
 * @date£º2018/3/13
 */

public class TryCatchSample {
    public static void main(String[] args) {
        System.out.println(ff());
    }


    public static String ff() {
        try {
            return "A";
        } catch (Exception e) {
            return "b";
        } finally {
            return "c";
        }
    }
   /* public static  String gg(String){

    }*/
}
