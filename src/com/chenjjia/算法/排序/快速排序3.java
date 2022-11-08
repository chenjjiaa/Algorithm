package com.chenjjia.算法.排序;

/**
 * Author：  chenjunjia
 * Date：    2022/7/18 15:24
 * WeChat：  China_JoJo_
 *
 * P4 2小时21分54秒
 * 增强版：随机选择基准数，以荷兰国旗方案来进行快排。
 * 随机基准数就是避免了人工构造的最差情况，将最差情况构建为具有统计规律的数学期望，
 * 这个概率复杂度为 n * log n
 */
public class 快速排序3 {
    public static void main(String[] args) {
        int[] arr = {5,2,4,8,9,6,2,5,3,2,1,4,7,8,5,3,6};
        quickSort(arr,0,arr.length-1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "  ");
        }
    }

    public static void quickSort(int[] arr,int L,int R) {
        if (null == arr && arr.length <= 1) {
            return;
        }
        if (L <= R) { // 如果没这个判断的话，产生随机数交换会数组越界：swap(int[] arr,int i,int j)中：arr[i] = arr[j];
                      // Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: -1
                      // L = 0 ,R = -1
                      // 原因应该是 在递归调用过程中 j-- 的过程中把 R 从 0 自减到了 -1，交换时导致-1数组越界
            /**
             * 函数用法：
             * 例：获取[50,100)之间的随机整数
             * Math.random()只能获取0-1之间的double值，
             * 若获取100之间的随机数则是 * 100
             * 若获取200之间的随机数是 * 200
             * 则获取数组范围内的随机位置是 * (R-L + 1)
             * 所以首先要获取0-50之间的随机数，所以 * 50，然后+50，
             * 随机数区间就会变为 [50,100) ,最后强制转换为int类型
             */
            /**
             * 完全随机值，避免了人为干扰，复杂度遵循概率统计规律，为 N * logN（以 2 为底）
             */
            swap(arr,L + (int) (Math.random() * (R - L + 1)), R); // 这个是给定范围的随机数
//        Random random = new Random();
//        random.nextInt(R); // 这个是 0 ~ bound 的，左边界一定包含 0，所以不适用
            int[] p = partition(arr,L,R);
            quickSort(arr, L, p[0] - 1); // 小于区域
            quickSort(arr,p[1] + 1,R); // 大于区域
        }
    }

    /**
     * @param R 随机挑选出来的基准数，作为荷兰国旗问题的 target值
     * @return int[] 数组包含两个数：划分值相等的左边界和右边界下标
     */
    public static int[] partition(int[] arr,int L,int R) {
        int less = L-1;
        int more = R+1;
        //int i = 0; // 不能用这个来代替数组下标了，要用 L 来代替，因为不一定都是从0 开始的了
        while (L < more) { // L 表示当前数
            if (arr[L] < arr[R]) { // 当前数 < arr[R]（target值）
                swap(arr,++less,L++);
            } else if (arr[L] == arr[R]) { // 当前数 = target值
                L++;
            } else { // 当前数 > target值
                swap(arr,--more,L);
            }
        }
        return new int[] {less+1, more-1}; // target相等区域的左边界、右边界下标
    }

    public static void swap(int[] arr,int i,int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
