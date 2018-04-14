package com;

/**
 * @description：常见算法
 * 参考地址：http://www.codeceo.com/8-java-sort.html
 * @author：JBL
 * @date：2018/4/13
 */

public class bubbleSort {

    /**
     * 冒泡排序
     * @param arr
     */
    public static  void bubbleSort(int[] arr) {
        int temp = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        for (int i = 0; i < arr.length; i++)
            System.out.println( arr[i] );
    }




    public static void main(String[] args) {
        int[] arr = {49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56, 17, 18, 23, 34, 15, 35, 25, 53, 51};
        bubbleSort(arr);
    }
}
