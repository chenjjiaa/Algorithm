package com.chenjjia.算法.LeetCode;

/**
 * Author：  chenjunjia
 * Date：    2022/11/12 14:47
 * WeChat：  China_JoJo_
 * Blog：    https://juejin.cn/user/1856417285289304/posts
 * Github：  https://github.com/chenjjiaa
 *
 * P26 1:34:00
 * 2019美团面试题
 * LeetCode 53.最大子数组和
 */

/**
 * 此方法用到的算法是：Kadane’s Algorithm:
 * 本题步骤（非DP）：定义两个变量：
 * ① cur，记录当前变量，当cur<0时，重置cur=0
 * ② max，当cur > max时，max更新。其余不变
 */

/**
 * 进阶题：子矩阵的最大累加和（类命名是：最大子矩阵）
 */
public class A53_最大子数组和 {
    public static void main(String[] args) {

    }

    public static int maxSubArray(int[] nums) {
        int cur = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            cur += nums[i];
            max = Math.max(max, cur);
            cur = cur < 0 ? 0 : cur;
        }
        return max;
    }
}
