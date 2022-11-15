package com.chenjjia.算法.LeetCode;

/**
 * Author：  chenjunjia
 * Date：    2022/11/15 20:19
 * WeChat：  China_JoJo_
 * Blog：    https://juejin.cn/user/1856417285289304/posts
 * Github：  https://github.com/chenjjiaa
 */
public class A74_搜索二维矩阵 {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 3, 5, 7},
                {10,11,16,20},
                {23,30,34,60}
        };
        int[][] i2 = {{1}};
        System.out.println(searchMatrix(i2, 2));
    }

    /**
     这题涉及一个贪心，也就是如何取舍，如何选择的问题
     如果强行遍历，那当然可以，但时间复杂度是 O(M * N)
     注意到这个矩阵，从左到右递增、从上往下递增
     则可以把路径规定为：只可以往左，往下

     于是思路可以是：
     1、从右上角开始找，若 target 小于当前值，则往左移动
     因为此时坐标的位置，往下的绝对不可能是 target 了，因为递增嘛
     2、若此时 matrix[i][j] 小于 target，那么就向下移动
     因为此时坐标位置的左边，再也没可能比 target 大了，因为左边的是递减嘛

     优化到这种程度，时间复杂度可以优化成：O(M + N)
     终止条件：数组越界，或者找到了数字
     */
    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }
        int j = matrix[0].length-1;
        for (int i = 0; i < matrix.length;) {
            while (j >= 0 && i < matrix.length) { // 这里内循环也要控制外循环的边界，要不然下面在数组会越界
                if (target == matrix[i][j])
                    return true;
                if (matrix[i][j] < target)  // 往下走
                    i++;
                else  // 往左走
                    j--;
            }
            return false;
        }
        return false;
    }
}
