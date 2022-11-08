package com.chenjjia.算法.排序;

/**
 * Author：  chenjunjia
 * Date：    2022/7/18 14:52
 * WeChat：  China_JoJo_
 *
 * 荷兰国旗问题增强版：也是快速排序的前置知识
 * 把一个数组划分为三个部分：左部分的数值小于target，中间部分等于target，右边部分大于target
 */
public class 荷兰国旗问题2 {

    public static void main(String[] args) {
        int[] arr = {5,1,5,4,7,8,9,5,2,5};
//        int[] arr = {5,2,4,8,9,6,2,5,4,7,8,5,3};
//        int[] arr = {5,2,4,8,9,6,2,5,3,2,1,4,7,8,5,3,6};
        partition(arr,0,arr.length-1,5);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "  ");
        }
    }

    public static void partition(int[] arr,int L,int R,int target) {
        int less = L-1;//最小值右侧边界
        int more = R+1;//最大值左侧边界
        int i = 0;//数组下标指针
//        while (i<R) {
        while (i < more) { //已到达最大区域就停止，如果是到达 R 再停止的话会交换重复
            if (arr[i] < target) {//小于的话，
                swap(arr,i++,++less);
            }else if (arr[i] == target) {
                i++;
            }else {
                swap(arr,i,--more);
            }
        }
    }

    public static void swap(int[] arr,int i,int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
