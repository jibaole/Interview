package com.�����㷨;

import org.junit.Test;

/**
 * @description��
 * @author��JBL
 * @date��2018/4/28
 */

public class ������ֵ {



    public int maxSum(int[] num){
        int curSum = 0;
        int curMaxSum = -99999999;
        int start = 0;
        int end = 0;

        for(int i=0;i<num.length;i++){
            if(curSum<=0){
                curSum = num[i];
                start = i;
            }
            else{
                curSum += num[i];
            }
            if(curSum>curMaxSum){
                curMaxSum = curSum;
                end = i;
            }
        }
        for(int i = start;i<=end;i++){
            System.out.println(num[i]);
        }
        return curMaxSum;
    }

    @Test
    public void test(){
        int[] num = {1,-2,3,10,-4,7,2,-5};
        //int[] num = {1,-2,3,10,-4,10,2,-5};
        System.out.println(maxSum(num));
    }
}
