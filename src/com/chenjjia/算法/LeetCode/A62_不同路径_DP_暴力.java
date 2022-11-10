package com.chenjjia.算法.LeetCode;

/**
 * Author：  chenjunjia
 * Date：    2022/11/10 11:29
 * WeChat：  China_JoJo_
 * Blog：    https://juejin.cn/user/1856417285289304/posts
 * Github：  https://github.com/chenjjiaa
 *
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 * 问总共有多少条不同的路径？
 *
 * 难度 mid
 */
public class A62_不同路径_DP_暴力 {
    public static void main(String[] args) {
        System.out.println(uniquePaths2(3, 7));
    }

    /**
     * 暴力递归版本
     */
    public static int uniquePaths1(int m, int n) {

        return process(0, 0, m-1, n-1);
    }

    /**
     * @param i 出发点行
     * @param j 出发点列
     * @param m 终止点行
     * @param n 终止点列
     */
    public static int process(int i, int j, int m, int n) {
        if (i > m || j > n) { // 越界条件
            return 0;
        }
        if (i == m && j == n) { // 终止条件
            return 1;
        }
        return process(i+1, j, m, n) + process(i, j+1, m, n);
    }

    /**
     * DP 版本
     */
    public static int uniquePaths2(int m, int n) {
        // 1、dp[m][n] 的含义：到达 m,n 位置所需要花费的步数
        int[][] dp = new int[m][n];
        // 2、递推公式 明确如何得到dp[i][j]：dp[i][j] 只能从两个方向过来：dp[i-1][j] 和 dp[i][j-1]
        // 3、初始化 dp[][]：因为到达dp[i][0] 和 dp[0][j] 的方法只有一种
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        // 4、遍历数组：从左到右，从上到下一层层遍历即可
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i][j-1] + dp[i-1][j];
            }
        }
        return dp[m-1][n-1];
    }
}
