package com.经典算法;

import org.junit.Test;

/**
 * @description：
 * @author：JBL
 * @date：2018/4/28
 * @Url： 经典算法题http://www.cnblogs.com/sunniest/p/4596182.html
 */

public class SubArraySum {
    /**
     * 给出一个排序好的数组和一个数，求数组中连续元素的和等于所给数的子数组
     * @param num
     * @param sum
     */
    public void findSum(int[] num, int sum) {
        int left = 0,right = 0;
        for (int i = 0; i < num.length; i++) {
            int curSum = 0;
            left = i;right = i;
            while (curSum < sum) {
                curSum += num[right++];
            }
            if (curSum == sum) {
                for (int j = left; j < right; j++) {
                    System.out.print( num[j] + " " );
                }
                System.out.println();
            }
        }
    }

    @Test
    public void test() {
        int[] num = {1, 2, 2, 3, 4, 5, 6, 7, 8, 9};
        int sum = 7;
        findSum( num, sum );
    }
}
