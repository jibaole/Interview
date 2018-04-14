package com;

/**
 * @description�������㷨
 * @desc:�ο���ַ��http://www.codeceo.com/8-java-sort.html
 * @author��JBL
 * @date��2018/4/13
 */


public class SortSf {

    /**
     * ð������
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
     * ֱ�Ӳ�������
     *
     * @param arr
     */
    public static void insertSort(int[] arr) {
        int temp = 0;
        for (int i = 1; i < arr.length; i++) {
            int j = i - 1;
            temp = arr[i];
            for (; j >= 0 && temp < arr[j]; j--) {
                /**������temp��ֵ�������һ����λ*/
                arr[j + 1] = arr[j];
            }
            arr[j + 1] = temp;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print( arr[i] + " " );
        }
    }

    /**
     * ��ѡ������
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
        //�鿴�����Ƿ�Ϊ��
        if (arr.length > 0) {
            _quickSort( arr, 0, arr.length - 1 );
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print( arr[i] + " " );
        }
    }

    public static int getMiddle(int[] list, int low, int high) {
        //����ĵ�һ����Ϊ����
        int tmp = list[low];
        while (low < high) {
            while (low < high && list[high] >= tmp) {
                high--;
            }
            //������С�ļ�¼�Ƶ��Ͷ�
            list[low] = list[high];
            while (low < high && list[low] <= tmp) {
                low++;
            }
            //�������ļ�¼�Ƶ��߶�
            list[high] = list[low];
        }
        //�����¼��β
        list[low] = tmp;
        //���������λ��
        return low;
    }

    public static void _quickSort(int[] list, int low, int high) {
        if (low < high) {
            //��list�������һ��Ϊ��
            int middle = getMiddle( list, low, high );
            //�Ե��ֱ���еݹ�����
            _quickSort( list, low, middle - 1 );
            //�Ը��ֱ���еݹ�����
            _quickSort( list, middle + 1, high );
        }
    }


    public static void main(String[] args) {
        int[] arr = {49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56, 17, 18, 23, 34, 15, 35, 25, 53, 51};
        //1��ð������
        bubbleSort( arr );
        System.out.println( "------------" );
        //2��ֱ�Ӳ�������
        insertSort( arr );
        System.out.println( "------------" );
        //3��ѡ������
        selectSort( arr );
        System.out.println( "------------" );
        //4����������
        quickSort( arr );
    }
}
