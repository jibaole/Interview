package com.data;

/**
 * @description：栈
 * 参考地址：https://www.cnblogs.com/rekent/p/6822743.html
 * @author：JBL
 * @date：2018/4/13
 */

public class Stack {


    static class mystack {
        int mytop;
        int stack[];

        public mystack(int num) {
            mytop = -1;
            stack = new int[num];
        }

        /**
         * 出栈
         */
        void mypop() {
            mytop--;
        }

        /**
         * 入栈
         */
        void mypush(int x) {
            mytop++;
            stack[mytop] = x;

        }

        /**
         * 判空
         */
        Boolean myisempty() {
            if (mytop == -1)
                return true;
            else
                return false;
        }

        /**
         * 取栈顶元素
         */
        int mypeek() {
            int peek = stack[mytop];
            return peek;
        }

        /**
         * 栈大小
         */
        int mysize() {
            return mytop + 1;
        }
    }


    public static void main(String[] args) {
        mystack myStack = new mystack( 20 );
        myStack.mypush( 1 );
        myStack.mypush( 2 );
        myStack.mypush( 3 );
        myStack.mypush( 4 );
        System.out.print( "栈大小为" + myStack.mysize() );
        System.out.println();
        for (int i = myStack.mytop; i >= 0; i--) {
            int get = myStack.mypeek();
            myStack.mypop();
            System.out.println( get );
        }

    }


}
