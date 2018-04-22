package test;

import java.util.Arrays;

/**
 * @description£∫
 * @author£∫JBL
 * @date£∫2018/4/17
 */

public class SortSF {

    /**
     * √∞≈›≈≈–Ú
     *
     * @param arr
     */
    public static void bubbleSort(int[] arr) {
        int temp = 0;
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println( arr[i] );
        }
    }

    public static void selectSort(int[] arr) {
        int p = 0;
        for (int i = 0; i < arr.length; i++) {
            int j = i + 1;
            p = i;
            int temp=arr[i];
            for (; j < arr.length; j++) {
                if(arr[j]<temp){
                    temp=arr[j];
                    p=j;
                }
            }
            arr[p]=arr[i];
            arr[i]=temp;
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println( arr[i] );
        }
    }


    public static int binarySearch(int[] arr,int key){
        Arrays.sort( arr );
        int start=0;
        int end=arr.length-1;
        while(start <= end){
            int medel=start+(end-start)/2;
            int temp=arr[medel];
            if(key<temp){
                end=medel-1;
            }else if(key >temp){
                start=medel+1;
            }else{
                return medel;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
      /*  int[] arr = {2, 5, 542, 21, 32, 321, 64, 7, 99};
        selectSort( arr );*/
        int[] arr = {22, 6, 12, 33, 87, 90, 97, 108, 5,61 };
        System.out.println(binarySearch(arr,6));

    }
}
