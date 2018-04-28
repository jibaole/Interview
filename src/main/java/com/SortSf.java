package com;

import java.util.Arrays;

/**
 * @description：常见算法
 * @desc:参考地址：http://www.codeceo.com/8-java-sort.html
 * @author：JBL
 * @date：2018/4/13
 */


public class SortSf {

    /**
     * 冒泡排序
     *
     * @param arr
     */
    public static void bubbleSort(int[] arr) {
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
            System.out.print( arr[i] + " " );
    }

    /**
     * 直接插入排序
     *
     * @param arr
     */
    public static void insertSort(int[] arr) {
        int temp = 0;
        for (int i = 1; i < arr.length; i++) {
            int j = i - 1;
            temp = arr[i];
            for (; j >= 0 && temp < arr[j]; j--) {
                /**将大于temp的值整体后移一个单位*/
                arr[j + 1] = arr[j];
            }
            arr[j + 1] = temp;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print( arr[i] + " " );
        }
    }

    /**
     * 简单选择排序
     *
     * @param arr
     */
    public static void selectSort(int[] arr) {
        int position = 0;
        for (int i = 0; i < arr.length; i++) {
            int j = i + 1;
            position = i;
            int temp = arr[i];
            for (; j < arr.length; j++) {
                if (arr[j] < temp) {
                    temp = arr[j];
                    position = j;
                }
            }
            arr[position] = arr[i];
            arr[i] = temp;
        }
        for (int i = 0; i < arr.length; i++)
            System.out.print( arr[i] + " " );
    }


    public static void quickSort(int[] arr) {
        //查看数组是否为空
        if (arr.length > 0) {
            _quickSort( arr, 0, arr.length - 1 );
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print( arr[i] + " " );
        }
    }

    public static int getMiddle(int[] list, int low, int high) {
        //数组的第一个作为中轴
        int tmp = list[low];
        while (low < high) {
            while (low < high && list[high] >= tmp) {
                high--;
            }
            //比中轴小的记录移到低端
            list[low] = list[high];
            while (low < high && list[low] <= tmp) {
                low++;
            }
            //比中轴大的记录移到高端
            list[high] = list[low];
        }
        //中轴记录到尾
        list[low] = tmp;
        //返回中轴的位置
        return low;
    }

    public static void _quickSort(int[] list, int low, int high) {
        if (low < high) {
            //将list数组进行一分为二
            int middle = getMiddle( list, low, high );
            //对低字表进行递归排序
            _quickSort( list, low, middle - 1 );
            //对高字表进行递归排序
            _quickSort( list, middle + 1, high );
        }
    }

    /**
     * @des
     * @param data
     * @param left
     * @param right
     */
    public static void sort(int[] data, int left, int right) {
        if (left < right) {
            //找出中间索引
            int center = (left + right) / 2;
            //对左边数组进行递归
            sort( data, left, center );
            //对右边数组进行递归
            sort( data, center + 1, right );
            //合并
            merge( data, left, center, right );

        }
    }

    /**
     * 归并排序
     * @param data
     * @param left
     * @param center
     * @param right
     */
    public static void merge(int[] data, int left, int center, int right) {
        int[] tmpArr = new int[data.length];
        int mid = center + 1;
        //third记录中间数组的索引
        int third = left;
        int tmp = left;
        while (left <= center && mid <= right) {

            //从两个数组中取出最小的放入中间数组
            if (data[left] <= data[mid]) {
                tmpArr[third++] = data[left++];
            } else {
                tmpArr[third++] = data[mid++];
            }
        }
        //剩余部分依次放入中间数组
        while (mid <= right) {
            tmpArr[third++] = data[mid++];
        }
        while (left <= center) {
            tmpArr[third++] = data[left++];
        }
        //将中间数组中的内容复制回原数组
        while (tmp <= right) {
            data[tmp] = tmpArr[tmp++];
        }
    }


    public static void main(String[] args) {
        int[] arr = {76, 13, 27, 49, 78, 34, 64, 5};
       /* //1、冒泡排序
        bubbleSort( arr );
        System.out.println("\n"+"------------" );
        //2、直接插入排序
        insertSort( arr );
        System.out.println("\n"+"------------" );
        //3、选择排序
        selectSort( arr );
        System.out.println("\n"+"------------" );
        //4、快速排序
        quickSort( arr );*/
        //5、归并排序
        sort(arr,0,arr.length-1);
        System.out.println("\n"+"------------" );
        System.out.println("\n"+ Arrays.toString( arr ) );
    }
}
