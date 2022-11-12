package com.chenjjia.算法.LeetCode;

/**
 * Author：  chenjunjia
 * Date：    2022/11/11 18:44
 * WeChat：  China_JoJo_
 * Blog：    https://juejin.cn/user/1856417285289304/posts
 * Github：  https://github.com/chenjjiaa
 *
 * LeetCode：https://leetcode.cn/problems/number-of-islands/
 */
public class A200_岛屿数量 {
    public static void main(String[] args) {
        int[][] matrix = {
                {0,0,1,0,1,0},
                {1,1,1,0,1,0},
                {1,0,0,1,0,0},
                {0,0,0,0,0,0}
        };
    }

    public static int numIslands(char[][] grid) {
        if(grid == null) {
            return 0;
        }
        int m = grid.length; // 边界
        int n = grid[0].length; // 边界
        int res = 0;
        for(int i = 0; i < m; i++) { // 从上到下，从左到右依次遍历
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == '1') { // 被感染过的自然进不来了
                    res++;
                    infected(grid, i, j, m, n);
                }
            }
        }
        return res;
    }

    // 感染过程：递归，将1感染成2
    // 其中 m n 是固定参数
    public static void infected(char[][] grid, int i, int j, int m, int n) {
        // 注意一下，越界分为上越界和下越界，千万也别漏了下越界
        if(i >= m || j >= n || i < 0 || j < 0 || grid[i][j] != '1') {
            return; // 若越界，或者当前值已经感染过了，则直接返回
        }
        // 感染
        grid[i][j] = '2';
        infected(grid, i+1, j, m, n); // 向上感染
        infected(grid, i-1, j, m, n); // 向下感染
        infected(grid, i, j+1, m, n); // 向右感染
        infected(grid, i, j-1, m, n); // 向左感染
    }
}
