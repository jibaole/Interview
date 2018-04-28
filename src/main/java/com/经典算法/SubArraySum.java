package com.�����㷨;

import org.junit.Test;

/**
 * @description��
 * @author��JBL
 * @date��2018/4/28
 * @Url�� �����㷨��http://www.cnblogs.com/sunniest/p/4596182.html
 */

public class SubArraySum {
    /**
     * ����һ������õ������һ������������������Ԫ�صĺ͵�����������������
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
