package com.chenjjia.算法.LeetCode;

/**
 * Author：  chenjunjia
 * Date：    2022/11/10 9:57
 * WeChat：  China_JoJo_
 * Blog：    https://juejin.cn/user/1856417285289304/posts
 * Github：  https://github.com/chenjjiaa
 */
public class A509_斐波那契数_DP {
    public static void main(String[] args) {
        System.out.println(fib(2));
    }

    public static int fib(int n) {
        if (n < 2) {
            if (n == 0) {
                return 0;
            }
            return 1;
        }
        // 第一步：确定dp数组下标含义：此时dp[i]为第i位的斐波那契结果
        int[] dp = new int[n+1];
        // 第二步：确定递推公式：本题为 dp[i] = dp[i-1] + dp[i-2]
        // 第三步：dp数组初始化
        dp[0] = 1;
        dp[1] = 1;
        // 第四步：确定遍历方式，本题是从左到右遍历
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n-1];
        // 第五步：举例推导dp数组
        // 第六步：可以在出错的时候打印 dp[] 数组
    }
}
