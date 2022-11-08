package com.chenjjia.算法.排序;

/**
 * Author：  chenjunjia
 * Date：    2022/7/18 11:16
 * WeChat：  China_JoJo_
 *
 * 荷兰国旗问题1：小于等于 target 的数放左边，大于 target 的数放数组右边
 * 例如：数组{5,2,4,8,9}，target 为 4
 * 输出结果是：{2,4,    5,8,9}
 */
public class 荷兰国旗问题1 {
    public static void main(String[] args) {
        int[] arr = {5,2,4,8,9,6,2,5,3,2,1,4,7,8,5,3,6};
//        int[] arr = {1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2};
        int[] a = {5,2,4,8,9,3,1};
        partition(arr,0,arr.length-1,4);
        printArray(arr);
    }
    public static void partition(int[] arr,int L,int R,int target) {
        if (arr == null || arr.length == 1) {
            return;
        }
        /**
         * 运用了快慢指针
         */
        int i = L; // 快指针
        int j = L-1; // 慢指针：表示小于等于 target 的部分
        while (i <= R) {
            if (arr[i] <= target) {
                swap(arr,i++,++j);
            }else {
                i++;
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
