package com.经典算法;

import org.junit.Test;

/**
 * @description：
 * @author：JBL
 * @date：2018/4/28
 */

public class RectanglePrint {
    /**
     * 顺时针打印一个矩阵
     * @param num
     * @param start
     * @param end
     */
    public void output(int[][] num,int start,int end){
        if(start>end || end<=0)return;
        for(int i=start;i<=end;i++){
            System.out.println(num[start][i]);
        }
        for(int i=start+1;i<=end;i++){
            System.out.println(num[i][end]);
        }
        for(int i=end-1;i>=start;i--){
            System.out.println(num[end][i]);
        }
        for(int i=end-1;i>start;i--){
            System.out.println(num[i][start]);
        }
        output(num,start+1,end-1);
    }


    @Test
    public void testOutput(){
        int n = 4;
        int[][] num = new int[n][n];
        int count =1;
        for(int i=0;i<n;i++){
            for(int j =0;j<n;j++){
                num[i][j]=count++;
            }
        }
        output(num,0,n-1);
    }
}
