package com.chenjjia.算法.排序;

/**
 * Author：  chenjunjia
 * Date：    2022/7/15 15:51
 * WeChat：  China_JoJo_
 */
public class 归并排序 {
    public static void main(String[] args) {
        int[] arr = {5,2,4,8,9,6,2,5,3,2,1,4,7,8,5,3,6};

        /**
         * R 的值一定一定一定一定一定一定要记得是 arr.length - 1，要不然会数组越界！
         * 在最外层循环的时候会越界
         */
        process(arr,0,arr.length-1);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "  ");
        }
    }

    public static void process(int[]arr,int L,int R) {
        if (L==R) {
            return;
        }
        int mid = L + ((R-L)>>1);
        process(arr, L, mid);
        process(arr, mid+1, R);
        merge(arr,L,mid,R);
    }

    /**
     * merge的过程实际上就是将原数组拆成一左一右，
     * 然后将两个数组的较小值放入一个新数组，最后将这个新数组拷贝回原数组返回
     */
    public static void merge(int[]arr,int L,int mid,int R) {
        int i = 0;//新数组的下标
        int p1 = L;//左数组的下标
        int p2 = mid+1;//右数组的下标
        int[] newArr = new int[R-L + 1];//空数组，到时候赋值回原数组，注意长度不能是 arr.length

        while (p1<=mid && p2<=R) {
            newArr[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++]; // 两个数字相等也先拷贝左边的数字会保证排序的稳定性
//            newArr[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++]; // 这里是先拷贝右边的，虽结果一样，但不能保证稳定性了。此外小和问题可以用这个
        }

        while (p1<=mid) {
            newArr[i++] = arr[p1++];
        }

        while (p2<=R) {
            newArr[i++] = arr[p2++];
        }

        for (int j = 0; j < newArr.length; j++) { // 不能用arr.length，要不然会让newArr数组越界
            arr[L + j] = newArr[j];
        }
    }
}