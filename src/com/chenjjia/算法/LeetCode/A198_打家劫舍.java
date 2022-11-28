package com.chenjjia.算法.LeetCode;

/**
 * Author：  chenjunjia
 * Date：    2022/11/18 15:32
 * WeChat：  China_JoJo_
 * Blog：    https://juejin.cn/user/1856417285289304/posts
 * Github：  https://github.com/chenjjiaa
 */
public class A198_打家劫舍 {

    /**
     直接推递推公式：
     两种可能性：遇到第 i 家，偷还是不偷
     1、偷了本家，就不能偷上家，要从 i-2 家开始：dp[i] = dp[i-2] + nums[i]
     2、不偷本家，可以偷上家，dp[i] = dp[i-1];
     两者取最大值：dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
     所以起始是从 i=2 开始，从左到右遍历
     */
    public int rob(int[] nums) {
        if (nums.length <= 2) {
            if (nums.length == 1) return nums[0];
            if (nums.length == 2) return Math.max(nums[0], nums[1]);
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
        }
        return dp[nums.length-1];
    }
}
