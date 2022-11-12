package com.chenjjia.算法.LeetCode;

import java.util.PriorityQueue;

/**
 * Author：  chenjunjia
 * Date：    2022/11/11 21:35
 * WeChat：  China_JoJo_
 * Blog：    https://juejin.cn/user/1856417285289304/posts
 * Github：  https://github.com/chenjjiaa
 */
public class A215_数组中的第K个最大元素 {
    public static void main(String[] args) {

    }

    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((n1, n2) -> n1 - n2); // lambda 表达式，比较器
        for (int i = 0; i < nums.length; i++) {
            heap.add(nums[i]);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        return heap.poll();
    }

    /**
     * 原本想自己造轮子的，结果发现太复杂了
     */
//    // 生成小根堆
//    public static void heapInsert(int[] arr, int index, int k) {
//        while (arr[index] < arr[(index-1) / 2] && index <= k) { // 子节点小于当前节点就换
//            swap(arr, index, (index-1) / 2);
//            index = index * 2 + 1;
//        }
//        // 如果此时堆大小为 k+1，则排序后弹出，然后再 heapify
//    }
//
//    public static void heapify(int[] arr, int index, int heapSize) {
//        int leftIndex = index * 2 + 1;
//        while (leftIndex > heapSize) {
//            int smaller = leftIndex + 1 > heapSize && arr[leftIndex + 1] < arr[leftIndex] ? leftIndex+1 : leftIndex;
//            smaller = arr[index] < arr[smaller] ? index : smaller;
//            if (smaller == index) break;
//            swap(arr, index, smaller);
//            index = smaller;
//            leftIndex = index * 2 + 1;
//        }
//    }
//
//    public static int pop(int[] arr, int index, int heapSize) {
//
//    }
//
//    public static int getFirst(int[] arr, int index) {
//        if (arr.length <= 0 || index >= arr.length) {
//            return Integer.MAX_VALUE; // 小根堆获取到系统最大，就说明不存在
//        }
//        return arr[index];
//    }
//
//    // 交换 i j 位置元素
//    public static void swap(int[] arr, int i, int j) {
//        int temp = arr[i];
//        arr[i] = arr[j];
//        arr[j] = temp;
//    }
}
