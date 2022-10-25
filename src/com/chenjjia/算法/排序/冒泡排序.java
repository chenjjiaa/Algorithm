package com.chenjjia.算法.排序;

/**
 * Author：  chenjunjia
 * Date：    2022/7/15 17:33
 * WeChat：  China_JoJo_
 *
 * 交换类排序的特点是直接交换序列中的元素，而不需要移动元素
 */
public class 冒泡排序 {

    public static void main(String[] args) {
        int[] arr = {5,2,4,8,9,6,2,5,3,2,1,4,7,8,5,3,6};
        bubbleSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "  ");
        }
    }

    public static void bubbleSort(int[] arr) {
        if (arr.length <= 1) { // 数组长度为 1，本身就是有序的，不用比较，直接返回
            return;
        }
        for (int i = 0; i < arr.length; i++) { // 控制循环多少次
            for (int j = 1; j < arr.length && j < arr.length-i; j++) { // 内层循环实现两两比较
                if (arr[j-1]>arr[j]) { // 前一个数比当前数大，则交换位置
                    swap(arr, j-1, j);
                }
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
