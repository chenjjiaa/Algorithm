package com.chenjjia.算法.排序;

/**
 * Author：  chenjunjia
 * Date：    2022/7/20 18:04
 * WeChat：  China_JoJo_
 */
public class 堆排序 {

    public static void main(String[] args) {
        int[] arr = {5,2,4,8,9,6,2,5,3,2,1,4,7,8,5,3,6};
        heapSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "  ");
        }
    }

    public static void heapSort(int[] arr) {
        if (null == arr || 2 > arr.length) {
            return;
        }
        // 将一个个元素插入到二叉树中，形成大根堆
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i); //O(logN)
        }
        int heapSize = arr.length;
        // 将数组末尾的元素和头部元素调换位置
        // 因为上面数组已经是大根堆了，所以头部的数字肯定是最大的，然后就往最后面交换！
        swap(arr, 0, --heapSize);
        // 一直重复这个步骤，直到 heapSize 为 1
        while (heapSize > 0) {
            heapify(arr, 0, heapSize);
            swap(arr, 0, --heapSize);
        }
    }

    /**
     * 一个个元素插入，形成大根堆
     * @param index 数字处在数组的位置
     *              数组 index 可以转化为二叉树，2i + 1 是左孩子，(i-1) / 2 是父节点
     */
    public static void heapInsert(int[] arr, int index) {
        //当前节点的值大于父节点的值，交换两个节点的位置
        while (arr[index] > arr[(index-1) / 2]) {
            swap(arr,index,(index-1) / 2);
            index = (index-1) / 2;
        }
    }

    /**
     * 在任意位置进行堆化操作，
     * @param index 数字处在数组的位置,往下做 heapify
     * @param heapSize 堆的大小。堆减至 0 说明大根堆已经全部弹出到数组中，管着左右孩子是否越界（数组的大小并不是堆的大小）
     */
    public static void heapify(int[] arr, int index, int heapSize) {
        int left = index * 2 + 1; // 左孩子下标
        while (left < heapSize) { // 有孩子，左孩子没越界
            // 可以向下比较
            // 左右孩子比较大小，较大数的下标，赋值给 largest 下标
            int largest = left + 1 < heapSize && arr[left + 1] > arr[left] ? left + 1 : left;

            // 孩子和父节点比大小
            largest = arr[largest] > arr[index] ? largest : index;

            if (largest == index) {
                // 若自身大于左右孩子，则中断循环，不用继续比较了
                break;
            }
            swap(arr,largest,index);
            index = largest; // 往下移动
            left = index * 2 + 1; // 刷新左孩子的下标
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
