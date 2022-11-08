package com.chenjjia.算法.排序;

/**
 * Author：  chenjunjia
 * Date：    2022/7/18 9:48
 * WeChat：  China_JoJo_
 *
 * 在一个数组中，每一个数左边比当前数小的数累加起来，叫做这个数组的小和。求一个数组的小和
 */
public class 小和问题 {

    public static void main(String[] args) {
        int[] arr = {5,2,4,8,9,6,2,5,3,2,1,4,7,8,5,3,6};
        int[] arr1 = {5,2,4,8,9,6};
        int[] arr2 = {6,5,4,3,2,1};
        System.out.println(process(arr,0,arr.length-1));
    }

    public static int process(int[] arr,int L,int R) {
        if (L == R) {
            return 0;
        }
        int M = L + ((R-L) >> 1);
        int left = process(arr,L,M);
        int right = process(arr,M+1,R);
        int merge = merge(arr,L,M,R);
        return left + right + merge;
    }

    public static int merge(int[] arr,int L,int M,int R) {
        int total = 0;
        int i = 0;
        int p1 = L;
        int p2 = M+1;
        int[] newArr = new int[R-L + 1]; //这里也不能写成 arr.length

        while (p1 <= M && p2 <= R) {
            total = total + (arr[p1] < arr[p2] ? (R - p2 + 1) * arr[p1] : 0); //不加括号，血的教训 ~
            newArr[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }

        while (p1 <= M) {
            newArr[i++] = arr[p1++];
        }

        while (p2 <= R) {
            newArr[i++] = arr[p2++];
        }

        for (int j = 0; j < newArr.length; j++) {//这里不能是原数组的 arr.length
//            arr[j] = newArr[j];
            arr[L + j] = newArr[j]; //这里要是 L + j，要不然右侧的会错
        }

        return total;
    }
}
