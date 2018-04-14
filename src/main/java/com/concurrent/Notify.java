package com.concurrent;

import java.util.ArrayList;
import java.util.List;

/**
 * @description£º
 * @author£ºJBL
 * @date£º2018/3/15
 */

public class Notify {
    public static void main(String[] args) {
        Object lock = new Object();
        MyList list = new MyList(lock);
        P p = new P(list);
        C c1 = new C(list);
        C c2 = new C(list);
        C c3 = new C(list);
        C c4 = new C(list);
        C c5 = new C(list);
        p.start();
        c1.start();
        c2.start();
        c3.start();
        c4.start();
        c5.start();
    }
}

class MyList {
    private static List list = new ArrayList();

    private static Object lock;

    public MyList(Object lock) {
        this.lock = lock;
    }

    public static void add() {
        synchronized (lock) {
            try {
                if (list.size() == 1) {
                    lock.wait();
                }
                long currentTimeMillis = System.currentTimeMillis();
                System.out.println("MyList add() time " + currentTimeMillis);
                list.add("time " + currentTimeMillis);
                lock.notify();
                System.out.println("add() notify " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static String pop() {
        String res = "";
        synchronized (lock) {
            try {
                if (list.size() == 0) {
                    System.out.println("========");
                    lock.wait();
                }
                res = list.get(0) + "";
                System.out.println("Mylist pop() " + res);
                list.remove(0);
                lock.notify();
                System.out.println("pop() notify " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return res;
    }
}

class P extends Thread {
    private MyList myList;

    public P(MyList myList) {
        this.myList = myList;
    }

    @Override
    public void run() {
        while (true) {
            myList.add();
        }
    }
}

class C extends Thread {
    private MyList myList;

    public C(MyList myList) {
        this.myList = myList;
    }

    @Override
    public void run() {
        while (true) {
            myList.pop();
        }
    }
}
