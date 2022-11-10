package com.chenjjia.算法.LeetCode;

/**
 * Author：  chenjunjia
 * Date：    2022/11/9 10:48
 * WeChat：  China_JoJo_
 * Blog：    https://juejin.cn/user/1856417285289304/posts
 * Github：  https://github.com/chenjjiaa
 *
 * LeetCode 剑指 Offer II 095. 最长公共子序列
 */

/**
 * 经典DP
 */
public class A_剑指OfferII_最长公共子序列_DP {
    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("abcdefghijk", "abcijk"));
    }

    public static int longestCommonSubsequence(String str1, String str2) {
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        int line = str1.length();
        int list = str2.length();

        /**
         * dp[i][j]：代表 str1[0 ~ i] 、str2[0 ~ j] 范围内，最长的公共子序列
         */
        int[][] dp = new int[list + 1][line + 1];
        /**
         * 将第一行第一列，赋值0：
         * [0, 0, 0, 0, 0, 0],
         * [0, x, x, x, x, x],
         * [0, x, x, x, x, x],
         * [0, x, x, x, x, x]
         */
        for (int i = 0; i < line + 1; i++) { // 初始化行
            dp[0][i] = 0;
        }
        for (int i = 0; i < list + 1; i++) { // 初始化列
            dp[i][0] = 0;
        }

        for (int i = 1; i < dp.length; i++) { // i代表列
            for (int j = 1; j < dp[0].length; j++) { // j代表行
                /**
                 * 会分为两种情况：
                 *      1： i 和 j 的字符相等
                 *
                 *      2： i 和 j 的字符不相等
                 *          2.1： chars[i] = chars[j - 1]
                 *          2.2： chars[i - 1] = chars[j]
                 *          则取两种情况最大值即可
                 */
                if (chars1[j - 1] == chars2[i - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[str2.length()][str1.length()];
    }
}
