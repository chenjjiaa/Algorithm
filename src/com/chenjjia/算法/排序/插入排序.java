package com.chenjjia.算法.排序;

/**
 * Author：  chenjunjia
 * Date：    2022/7/15 17:33
 * WeChat：  China_JoJo_
 *
 * 插入类排序的特点是将待排序元素直接插入到指定位置，从而其他的元素都要做相应的移动
 */
public class 插入排序 {
    public static void main(String[] args) {
        int[] arr = {5,2,4,8,9,6,2,5,3,2,1,4,7,8,5,3,6};
        insertSort(arr);
        printArray(arr);
    }

    /**
     * 直接插入排序
     * （另一种是希尔排序）
     */
    public static void insertSort(int[] arr) {
        if (null == arr && arr.length <= 1) {
            return;
        }
        /**
         * 循环要从1号下标开始，因为0号下标本身就是有序的了
         * 外层循环的作用：做到 0 ~ i 范围有序，这里一开始 0 下标只有一个元素，本身就是有序的
         *              并且不断将新元素添加到有序子序列中去
         * 内层循环的作用：将新元素插入到自序列中合适的位置，变成新的有序序列（所以要在自序列中不断循环比较）
         */
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0 && arr[j] > arr[j+1]; j--) {
//                swap(arr,arr[j],arr[j+1]); // 又搞错了下标和数组中元素的关系。。。
                swap(arr, j, j+1); // j 是内循环的动态变量，j 变化得快，所以不能用 i 来代表 j+1
            }
        }
    }

    public static void swap(int[] arr,int i,int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void printArray(int[] arr) {
        System.out.print("Array : ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "  ");
        }
    }
}
