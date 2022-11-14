package com.chenjjia.算法.LeetCode;

import java.util.*;

/**
 * Author：  chenjunjia
 * Date：    2022/11/14 23:19
 * WeChat：  China_JoJo_
 * Blog：    https://juejin.cn/user/1856417285289304/posts
 * Github：  https://github.com/chenjjiaa
 *
 * LeetCode：https://leetcode.cn/problems/next-permutation/
 */
public class A31_下一个排列 {
    public static void main(String[] args) {

    }

    // 感觉这题还是要一些数学功底的，比如单调递增遇到转折点的时候
    public static void nextPermutation(int[] nums) {
        if (nums.length == 1) return;
        for (int i = nums.length-1; i >= 0; i--) {
            if (i == 0) {
                Arrays.sort(nums); // 如果一直都是递增，则此时字典序最大，重新排列数组
                return;
            } else {
                if (nums[i] > nums[i-1]) { // 遇到了降序
                    Arrays.sort(nums, i, nums.length);  // 对转折点后面部分做一个排序，区间：[i, j)
                    for (int j = i; j < nums.length; j++) {
                        if (nums[i-1] < nums[j]) { // 当转折点的数字，遇到了第一个比他大的，就交换
                            int temp = nums[i-1];
                            nums[i-1] = nums[j];
                            nums[j] = temp;
                            return; // 交换完别忘记返回
                        }
                    }
                }
            }
        }
    }
}
