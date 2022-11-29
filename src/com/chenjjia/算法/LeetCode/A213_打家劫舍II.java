package com.chenjjia.算法.LeetCode;

/**
 * Author：  chenjunjia
 * Date：    2022/11/18 21:47
 * WeChat：  China_JoJo_
 * Blog：    https://juejin.cn/user/1856417285289304/posts
 * Github：  https://github.com/chenjjiaa
 */
public class A213_打家劫舍II {

    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        if (nums.length == 3) return Math.max(nums[0], Math.max(nums[1], nums[2]));
        // dp[] 的含义是：dp[i] 是当前能偷到的最大钱数
        int[] dp = new int[nums.length];
        /**
         * dp[i] 所在的地方，可以选择偷或者不偷
         * 如果 i-1 位置偷了，当前位置 dp[i] 就不能偷
         * 如果 dp[0] 偷了，dp[dp.length - 1] 就不能偷
         *
         * 于是有两种解决方案
         *      第一种：偷第一个，不偷最后一个，且第一个可偷可不偷
         *             偷最后一个，不偷第一个，且最后一个可偷可不偷
         *      第二种：组成两个组
         *            一组是 0 ~ dp.length-2
         *            一组是 1 ~ dp.length-1
         *            然后比较大小
         *
         *  在这里选择第二种方案
         */
        // 偷第一个不偷最后一个
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < dp.length - 1; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
        }
        int robFirst = dp[dp.length - 2];

        // 不偷第一个，偷最后一个
        dp[0] = 0;
        dp[1] = nums[1];
        dp[2] = Math.max(nums[1], nums[2]);
        for (int i = 3; i < dp.length && i < nums.length; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
        }
        int res = Math.max(robFirst, dp[dp.length-1]);
        return res;
    }
}
