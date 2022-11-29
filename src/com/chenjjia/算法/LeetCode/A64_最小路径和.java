package com.chenjjia.算法.LeetCode;

/**
 * Author：  chenjunjia
 * Date：    2022/11/18 21:27
 * WeChat：  China_JoJo_
 * Blog：    https://juejin.cn/user/1856417285289304/posts
 * Github：  https://github.com/chenjjiaa
 *
 * LeetCode：https://leetcode.cn/problems/minimum-path-sum/?favorite=2cktkvj
 */
public class A64_最小路径和 {

    public int minPathSum(int[][] grid) {
        // dp[i][j] 代表能到达此处的最小路径和
        int[][] dp = new int[grid.length][grid[0].length];

        // dp[][] 数组初始化
        int initRow = 0;
        for (int i = 0; i < dp.length; i++) {
            initRow += grid[i][0];
            dp[i][0] = initRow;
        }
        int initCol = 0;
        for (int i = 0; i < dp[0].length; i++) {
            initCol += grid[0][i];
            dp[0][i] = initCol;
        }
        // 递推公式：因为每个点只能从上方、左方过来，所以选比较小的
        // dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
            }
        }
        return dp[dp.length][dp[0].length];
    }
}
