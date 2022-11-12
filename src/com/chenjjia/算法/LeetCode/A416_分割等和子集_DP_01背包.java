package com.chenjjia.算法.LeetCode;

/**
 * Author：  chenjunjia
 * Date：    2022/11/10 18:59
 * WeChat：  China_JoJo_
 * Blog：    https://juejin.cn/user/1856417285289304/posts
 * Github：  https://github.com/chenjjiaa
 *
 * 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 *
 * 示例 1：
 * 输入：nums = [1,5,11,5]
 * 输出：true
 * 解释：数组可以分割成 [1, 5, 5] 和 [11]
 *
 * 示例 2：
 * 输入：nums = [1,2,3,5]
 * 输出：false
 * 解释：数组不能分割成两个元素和相等的子集。
 */
public class A416_分割等和子集_DP_01背包 {
    public static void main(String[] args) {
        int[] arr = {1,5,11,5};
        System.out.println(canPartition(arr));
    }

    public static boolean canPartition(int[] nums) {
        if (nums == null || nums.length < 2) {
            return false;
        }
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        // 判断能不能分割成两个相等子集，若数组总和不是偶数，那么失败，直接返回 false
        if ((sum & 1) == 1) {
            return false;
        }
        int bag = sum / 2;
        // dp[i][j]：当前容量能装下的最大value值
        int[][] dp = new int[nums.length][bag + 1];
        // 递推公式和 01 背包的一样
        // 初始化数组
        for (int i = nums[0]; i < bag; i++) {
            if (nums[0] > bag) {
                break;
            }
            dp[0][i] = nums[0];
        }
        // 遍历：从左往右，从上到下
        for (int i = 1; i < nums.length; i++) {
            for (int j = 1; j <= bag; j++) {
                if (j < nums[i]) { // 装不下
                    dp[i][j] = dp[i-1][j]; // 不装了
                } else {
                    // 能装就挑个最大的装
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-nums[i]] + nums[i]);
                }
            }
        }
        return dp[nums.length - 1][bag] == bag;
    }
}
