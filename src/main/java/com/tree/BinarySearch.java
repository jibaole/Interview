package com.tree;

import java.util.Arrays;

/**
 * 二分查找算法
 * <b>
 * 二分查找是一个搜索算法,也叫折半查找,就是将查找的键和子数组的中间键作比较，如果被查找的键小于中间键，
 * 就在左子数组继续查找;如果大于中间键，就在右子数组中查找，否则中间键就是要找的元素。
 * 参考网址：https://www.cnblogs.com/lonelywolfmoutain/p/6907250.html
 * @author jbl
 * @date 2018-05-24 11:27
 * @since 1.8
 */

public class BinarySearch {

    /**
     * 二分查找
     * @param keys  要检索的数组
     * @param key   要检索的元素
     * @return
     */
    public static int search(int[] keys ,int key){
        //先排序
        Arrays.sort(keys);
        //指定开始查找的位置
        int start = 0;
        //结束的位置
        int end = keys.length-1;
        while (start <= end){
            //中间位置索引
            int middle = start + (end-start)/2;
            //中间元素
            int middleKey = keys[middle];
            if (key > middleKey){
                //大于中间元素,从右边部分查找
                start = middle+1;
            } else if (key < middleKey){
                //小于中间元素,从左边开始查找
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
