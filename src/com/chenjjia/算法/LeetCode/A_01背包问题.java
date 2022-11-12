package com.chenjjia.算法.LeetCode;

/**
 * Author：  chenjunjia
 * Date：    2022/11/10 17:37
 * WeChat：  China_JoJo_
 * Blog：    https://juejin.cn/user/1856417285289304/posts
 * Github：  https://github.com/chenjjiaa
 */
public class A_01背包问题 {
    public static void main(String[] args) {
        int[] values = {1,100};
        int[] weights = {1,2};
        System.out.println(maxValue(values, weights, 2));
    }

    public static int maxValue(int[] value, int[] weight, int bag) {
        // 1、dp[i][j]：此位置能放入的最大价值
        // i 代表物品重量，j 代表背包容量
        int[][] dp = new int[value.length][bag + 1];
        // 2、递推公式：可以分为拿和不拿
        // 不拿：dp[i][j] = dp[i-1][j]，也就是上一个物品的价值，那就是 i-1
        // 拿：dp[i][j] = dp[i-1][j - weight[i]] + value[i]
        // 因为选择拿物品，所以先要扣除相应的背包重量得到剩余重量，再加上价值
        // 因此整条递推公式为：dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weight[i]] + value[i]);
        // 3、dp 数组初始化
        for (int i = weight[0]; i < bag + 1; i++) {
            if (weight[0] > bag) {
                break;
            }
            dp[0][i] = value[0];
        }
        // 4、遍历数组
        for (int i = 1; i < weight.length; i++) {
            for (int j = 0; j <= bag; j++) {
                if (j < weight[i]) { // 单独的 j 是代表背包剩余容量，此时是背包容量不够的情况
                    dp[i][j] = dp[i-1][j]; // 若背包容量不够，那就不选
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weight[i]] + value[i]);
                }
            }
        }
        return dp[weight.length - 1][bag];
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
