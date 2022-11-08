package com.chenjjia.算法.排序;

/**
 * Author：  chenjunjia
 * Date：    2022/7/15 17:36
 * WeChat：  China_JoJo_
 *
 * 选择类排序和直接插入类排序有些许的相似之处，其特点是每一趟都从待排序元素中选取最小的，然后放入有序子序列中去
 */
public class 选择排序 {
    public static void main(String[] args) {
        int[] arr = {5,2,4,8,9,6,2,5,3,2,1,4,7,8,5,3,6};
        selectionSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "  ");
        }
    }

    /**
     * 易错点：下标和数组值的关系
     *        数组长度和数组下标的关系
     *        数组长度和左右下标运算的关系
     */
    public static void selectionSort(int[] arr) {
        if (null == arr && arr.length <= 1) {
            return;
        }
        int min;
        for (int i = 0; i < arr.length; i++) {
            min = i; // 最开始是指向数组第一个元素
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            swap(arr,i,min);
        }
    }

    public static void swap(int[] arr,int i,int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
