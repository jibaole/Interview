package com.tree;

import java.util.Arrays;

/**
 * ���ֲ����㷨
 * <b>
 * ���ֲ�����һ�������㷨,Ҳ���۰����,���ǽ����ҵļ�����������м�����Ƚϣ���������ҵļ�С���м����
 * �������������������;��������м�����������������в��ң������м������Ҫ�ҵ�Ԫ�ء�
 * �ο���ַ��https://www.cnblogs.com/lonelywolfmoutain/p/6907250.html
 * @author jbl
 * @date 2018-05-24 11:27
 * @since 1.8
 */

public class BinarySearch {

    /**
     * ���ֲ���
     * @param keys  Ҫ����������
     * @param key   Ҫ������Ԫ��
     * @return
     */
    public static int search(int[] keys ,int key){
        //������
        Arrays.sort(keys);
        //ָ����ʼ���ҵ�λ��
        int start = 0;
        //������λ��
        int end = keys.length-1;
        while (start <= end){
            //�м�λ������
            int middle = start + (end-start)/2;
            //�м�Ԫ��
            int middleKey = keys[middle];
            if (key > middleKey){
                //�����м�Ԫ��,���ұ߲��ֲ���
                start = middle+1;
            } else if (key < middleKey){
                //С���м�Ԫ��,����߿�ʼ����
                end = middle-1;
            }else {
                return middle;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {22, 6, 12, 33, 87, 90, 97, 108, 5,61 };
        System.out.println(search(arr,6));
    }
}
