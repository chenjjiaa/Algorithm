package com.chenjjia.算法.LeetCode;

/**
 * Author：  chenjunjia
 * Date：    2022/11/10 12:51
 * WeChat：  China_JoJo_
 * Blog：    https://juejin.cn/user/1856417285289304/posts
 * Github：  https://github.com/chenjjiaa
 *
 * 给定一个正整数 n ，将其拆分为 k 个 正整数 的和（ k >= 2 ），并使这些整数的乘积最大化。
 * 返回 你可以获得的最大乘积
 *
 * 示例 1:
 * 输入: n = 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1。
 *
 * 示例 2:
 * 输入: n = 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
 */
public class A343_数字拆分_DP_贪心 {
    public static void main(String[] args) {
        System.out.println(integerBreak(20));
        System.out.println(integerBreak2(20));
    }

    /**
     * DP
     */
    public static int integerBreak(int n) {
        if (n == 2) return 1;
        if (n == 3) return 2;
        // dp[i]：当数字为 i 的时候拆分的乘积的最大值
        int[] dp = new int[n+1];
        // 递推公式：
        // 初始化dp[]：i = 0,1 无意义。
        dp[2] = 1;
        // 遍历数组：从左到右推出
        // TODO: 2022/11/10
//        for (int i = 4; i <= n; i++) {
//            for (int j = 1; j < i-1; j++) {
//                dp[i] = Math.max(dp[i], Math.max(j * i-j, j * dp[i-j]));
//            }
//        }
        return dp[n];
    }

    /**
     * 贪心：
     * 本题也可以用贪⼼，每次拆成 n个3，如果剩下是4，则保留4，然后相乘
     * 但是这个结论需要数学证明其合理性！
     */
    public static int integerBreak2(int n) {
        if (n == 2) return 1;
        if (n == 3) return 2;
        if (n == 4) return 4;

        int res = 1;
        while (n > 4) {
            res *= 3;
            n -= 3;
        }
        return res * n;
    }
}
