package com.chenjjia.算法.LeetCode;

/**
 * Author：  chenjunjia
 * Date：    2022/9/23 21:10
 * WeChat：  China_JoJo_
 *
 * 给定一个非负整数n，代表二叉树的节点个数。返回能形成多少种不同的二叉树结构
 *
 * 这题之前写过，类名叫：N个节点二叉树有几种不同结构_DP
 * P21 0分40+秒。代码部分 3:58 动态规划部分 05:12
 *
 * LeetCode 96.不同的二叉搜索树
 */
public class A96_不同的搜素二叉树_DP_暴力递归 {
    public static void main(String[] args) {
        System.out.println(numbers_DP(10));
        System.out.println(numbers_Process(10));
    }

    /**
     * 暴力递归
     */
    public static int numbers_Process(int n) {
        int result = 0;
        if (n < 0) return 0;
        if (n == 0) return 1;
        if (n == 1) return 1;
        if (n == 2) return 2;

        for (int leftSize = 0; leftSize <= n-1; leftSize++) {
            int leftSum = numbers_Process(leftSize); // 如果传入的leftSize等于0，则会直接return 1，所以 leftSum 不可能等于 0
            int rightSum = numbers_Process(n - leftSize - 1);
            // 每种情况的 左 * 右
            // 总节点n  左个数n-1  右个数0  左情况f(n-1)   右情况(0)
            // 总节点n  左个数n-2  右个数1  左情况f(n-2)   右情况(1)
            // 总节点n  左个数n-3  右个数2  左情况f(n-3)   右情况(2)
            // 总节点n  左个数i  右个数n-i-1  左情况f(i)   右情况(n-i-1)
            // ……
            // 总情况 = 每次循环出来的 左情况 * 右情况
            result += leftSum * rightSum;
        }
        return result;
    }

    /**
     * 动态规划 记忆化搜索
     */
    public static int numbers_DP(int n) {
        if (n < 0) return 0;
        if (n == 0) return 1;
        if (n == 1) return 1;
        if (n == 2) return 2;
        // dp[i] 代表的是 i 个节点最多有 dp[i] 种结构
        int[] dp = new int[n+1];
        dp[0] = 1;
        // 从左往右遍历，一直到 n+1 的位置，因为第0个不算，从第1个位置开始的，最后返回 dp[n] 就是最终答案
        for (int i = 1; i < n+1; i++) { // i 表示一共有多少个节点
            for (int leftSize = 0; leftSize <= i-1; leftSize++) { // 左边最多有 i-1 个节点
                dp[i] += dp[leftSize] * dp[i - leftSize - 1];
            }
        }
        return dp[n];
    }

    private static void printArray(int[] arr) {
        System.out.println("打印开始===============");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "  ");
        }
        System.out.println();
        System.out.println("打印结束===============");
    }
}
