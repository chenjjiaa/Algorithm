package com.chenjjia.算法.LeetCode;

/**
 * Author：  chenjunjia
 * Date：    2022/11/10 10:15
 * WeChat：  China_JoJo_
 * Blog：    https://juejin.cn/user/1856417285289304/posts
 * Github：  https://github.com/chenjjiaa
 *
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 */

/**
 * DP、记忆化搜搜
 *
 * 从 dp[i] 的定义可以看出，dp[i] 可以有两个方向推出来。
 * 首先是 dp[i - 1]，上 i-1 层楼梯，有 dp[i - 1] 种⽅法，那么再⼀步跳⼀个台阶不就是 dp[i] 了么
 * 还有就是 dp[i - 2]，上 i-2 层楼梯，有 dp[i - 2] 种⽅法，那么再⼀步跳两个台阶不就是 dp[i] 了么
 */
public class A70_爬楼梯_DP {
    public static void main(String[] args) {
        System.out.println(climbStairs(2));
    }

    /**
     * 这题就是斐波那契的变式。
     * 唯⼀的区别是，没有讨论dp[0]应该是什么，因为dp[0]在本题没有意义！
     */
    public static int climbStairs(int n) {
        if (n < 2) {
            return n == 0 ? 0 : 1;
        }
        // 1、确定 dp[i] 的含义：爬到第 i 层，有 dp[i] 种方法
        int dp[] = new int[n+1];
        // 2、递推公式：dp[i] = dp[i-1] + dp[i-2]
        // 3、初始化数组
        dp[1] = 1;
        dp[2] = 2;
        // 4、遍历方式：从左到右，这里要从3开始
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
//        printArray(dp);
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
