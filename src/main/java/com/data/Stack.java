package com.data;

/**
 * @description��ջ
 * �ο���ַ��https://www.cnblogs.com/rekent/p/6822743.html
 * @author��JBL
 * @date��2018/4/13
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
         * ��ջ
         */
        void mypop() {
            mytop--;
        }

        /**
         * ��ջ
         */
        void mypush(int x) {
            mytop++;
            stack[mytop] = x;

        }

        /**
         * �п�
         */
        Boolean myisempty() {
            if (mytop == -1)
                return true;
            else
                return false;
        }

        /**
         * ȡջ��Ԫ��
         */
        int mypeek() {
            int peek = stack[mytop];
            return peek;
        }

        /**
         * ջ��С
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
        System.out.print( "ջ��СΪ" + myStack.mysize() );
        System.out.println();
        for (int i = myStack.mytop; i >= 0; i--) {
            int get = myStack.mypeek();
            myStack.mypop();
            System.out.println( get );
        }

    }


}
