package test;

/**
 * @description£º
 * @author£ºJBL
 * @date£º2018/4/30
 */

public class ArrayCoum {

    public static void getArraySortWay(int[] arr, int f) {
        int left = 0, right = 0;
        for (int i = 0; i < arr.length; i++) {
            left = i;right = i;
            int tolSum = 0;
            while (tolSum < f) {
                tolSum += arr[right++];
            }
            if (tolSum == f) {
                for (int j = left; j < right; j++) {
                    System.out.print( arr[j] + " " );
                }
                System.out.println();
            }

        }
    }

    public static void main(String[] args){
        int[] num = {1, 2, 2, 3, 4, 5, 6, 7, 8, 9};
        int sum = 7;
        getArraySortWay(num,sum);
    }
}
