package com.chenjjia.算法.LeetCode;

/**
 * Author：  chenjunjia
 * Date：    2022/11/18 19:46
 * WeChat：  China_JoJo_
 * Blog：    https://juejin.cn/user/1856417285289304/posts
 * Github：  https://github.com/chenjjiaa
 */

/**
 * 方法一：一圈圈翻转
 *
 * 方法二：先按主对角线翻转，再按中心线左右翻转
 * 此方法视频链接：https://www.bilibili.com/video/BV1Sq4y1t7tj/?spm_id_from=333.788&vd_source=72ad5c1392d035e00c5326eb4487626b
 */
public class A48_旋转图像 {
    /**
     * 使用方法二会简单些
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        /**
         * 先按照主对角线翻转
         */
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                // matrix[i][j] 与 matrix[j][i] 互为主对角线对称
                swap(matrix, i, j, j, i);
            }
        }
        /**
         * 再进行对称翻转
         */
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                // matrix[i][j] 与 matrix[i][n-1-j] 互为中心线对称
                swap(matrix, i, j, i, (n - 1 - j));
            }
        }
    }

    /**
     * @param i 第一个点位 matrix[i][j] 的 i
     * @param j 第一个点位 matrix[i][j] 的 j
     * @param a 第二个点位 matrix[a][b] 的 a
     * @param b 第二个点位 matrix[a][b] 的 b
     */
    public void swap(int[][] matrix, int i, int j , int a, int b) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[a][b];
        matrix[a][b] = temp;
    }
}
