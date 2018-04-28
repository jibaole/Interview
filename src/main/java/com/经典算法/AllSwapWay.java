package com.经典算法;

import org.junit.Test;

/**
 * @description：
 * @author：JBL
 * @date：2018/4/28
 */

public class AllSwapWay {
    /**
     * 字符数组组成的所有字符串
     * @param cs
     * @param start
     * @param length
     */
    public void recursionSwap(char[] cs,int start,int length){
        if(start>=length-1){
            print(cs);
            return;
        }
        for(int i=start;i<length;i++){
            swap(cs,start,i);
            recursionSwap(cs,start+1,length);
            swap(cs,start,i);
        }
    }

    public void swap(char[] cs,int index1,int index2){
        char temp = cs[index1];
        cs[index1]=cs[index2];
        cs[index2]=temp;
    }



    public void print(char[] cs){
        for(int i=0;i<cs.length;i++){
            System.out.print(cs[i]);
        }
        System.out.println();
    }

    @Test
    public void testswap(){
        char[] cs = {'a','b','c'};
        recursionSwap(cs,0, cs.length);
    }
}
