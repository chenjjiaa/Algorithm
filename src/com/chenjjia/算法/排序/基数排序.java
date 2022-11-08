package com.chenjjia.算法.排序;

/**
 * Author：  chenjunjia
 * Date：    2022/7/21 17:44
 * WeChat：  China_JoJo_
 */
public class 基数排序 {

    public static void main(String[] args) {
        int[] arr = {5,2,4,8,9,6,2,5,3,2,1,4,7,8,5,3,6};

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "  ");
        }
    }

    public static void ridixSort(int[] arr) {

    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
