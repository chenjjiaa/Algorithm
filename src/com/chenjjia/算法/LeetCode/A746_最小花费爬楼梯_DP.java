package com.chenjjia.算法.LeetCode;

/**
 * Author：  chenjunjia
 * Date：    2022/11/10 10:46
 * WeChat：  China_JoJo_
 * Blog：    https://juejin.cn/user/1856417285289304/posts
 * Github：  https://github.com/chenjjiaa
 *
 * 给你一个整数数组 cost ，其中 cost[i] 是从楼梯第 i 个台阶向上爬需要支付的费用
 * 一旦你支付此费用，即可选择向上爬一个或者两个台阶
 * 你可以选择从下标为 0 或下标为 1 的台阶开始爬楼梯
 *
 * tag：DP、数组
 */
public class A746_最小花费爬楼梯_DP {
    public static void main(String[] args) {
        int [] arr = new int[] {10,15,20};
        System.out.println(minCostClimbingStairs(arr));
    }

    /**
     * @param cost cost[i] 是从楼梯第 i 个台阶向上爬需要支付的费用
     * @return 达到楼梯顶部的最低花费。
     */
    // AC 时间：2022年11月12日17:42:05
    public static int minCostClimbingStairs(int[] cost) {
        if (cost.length == 0) {
            return 0;
        }
        // 1、dp[i] 的含义：第 i 级台阶的最小花费
        int[] dp = new int[cost.length + 1];
        // 2、递推公式：dp[i] 能由 dp[i-1]、dp[i-2] 得到，而且取最小值，然后加上当前花费 cost[i]
        // 3、初始化 dp[] 数组
        dp[0] = cost[0];
        dp[1] = cost[1];
        // 4、遍历dp[] 的方式：从左到右
        for (int i = 2; i < cost.length; i++) {
            dp[i] = Math.min(dp[i-1], dp[i-2]) + cost[i];
        }
        // 最后一级台阶可以从 i-1 或 i-2跳，所以取最小
        return Math.min(dp[cost.length-1], dp[cost.length-2]);
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
