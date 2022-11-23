package com.chenjjia.算法.LeetCode;

import java.util.*;

/**
 * Author：  chenjunjia
 * Date：    2022/11/17 21:03
 * WeChat：  China_JoJo_
 * Blog：    https://juejin.cn/user/1856417285289304/posts
 * Github：  https://github.com/chenjjiaa
 *
 * LeetCode：https://leetcode.cn/problems/spiral-matrix/
 */
public class A54_螺旋矩阵 {
    /**
     这题看过，P23 26min
     思路：定义一个函数，他的功能是，传入左上角和右下角，顺时针打印这两个点围成的一个圈的数字
     也就是一圈圈打印
     */
    List<Integer> ans = new ArrayList<>();
    public List<Integer> spiralOrder(int[][] matrix) {
        // 只需要将左上角的行和列，右下角的行和列传入 addEdge() 即可
        int lr = 0; // 左上角的行
        int lc = 0; // 左上角的列
        int rr = matrix.length - 1;
        int rc = matrix[0].length - 1;
        while (lr <= rr && lc <= rc) {
            addEdge(matrix, lr++, lc++, rr--, rc--);
        }
        return ans;
    }

    /**
     * @param leftRow   左上角的行，行为是从上往下，从0开始
     * @param leftCol   左上角的列，行为是从左往右，从0开始
     * @param rightRow  右上角的行，行为是从下往上
     * @param rightCol  右上角的列，行为是从右往左
     */
    public void addEdge(int[][] matrix, int leftRow, int leftCol, int rightRow, int rightCol) {
        // o ------ o
        if (leftRow == rightRow) { // 两个点在同一行的情况
            for (int i = leftCol; i <= rightCol; i++) {
                ans.add(matrix[leftRow][i]);
            }
        } else if (leftCol == rightCol) { // 两个点在同一列的情况
            for (int i = leftRow; i <= rightRow; i++) {
                ans.add(matrix[i][leftRow]);
            }
        } else { // 普遍情况
            // 四个 while 搞定往左走，往下走，往右走，往上走
            int curR = leftRow;
            int curC = leftCol;
            while (curC != rightCol) { // 往右走
                ans.add(matrix[leftRow][curC++]);
            }
            while (curR != rightRow) { // 往下走
                ans.add(matrix[curR++][rightCol]);
            }
            while (curC != leftCol) { // 往左走
                ans.add(matrix[rightRow][curC--]);
            }
            while (curR != leftRow) { // 往上走
                ans.add(matrix[curR--][leftCol]);
            }
        }
    }
}
