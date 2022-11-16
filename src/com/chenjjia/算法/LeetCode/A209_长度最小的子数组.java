package com.chenjjia.算法.LeetCode;

/**
 * Author：  chenjunjia
 * Date：    2022/11/16 0:47
 * WeChat：  China_JoJo_
 * Blog：    https://juejin.cn/user/1856417285289304/posts
 * Github：  https://github.com/chenjjiaa
 *
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 * 找出该数组中满足其和 ≥ target 的长度最小的连续子数组 
 * [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。
 * 如果不存在符合条件的子数组，返回 0 。
 *
 * 示例 1：
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 *
 * 链接：https://leetcode.cn/problems/minimum-size-subarray-sum
 */

/**
 * 说人话就是：返回一个数组，要求数组里的：
 * 1：[n1, n2, n3, n4...] 数组里的数字之和 ≥ target
 * 2：且要求数组长度最短
 */
public class A209_长度最小的子数组 {
    public static void main(String[] args) {

    }

    /**
     * 可以用双指针，代表一个【窗口】
     * 右边指针代表结束位置，左边指针可以向右边缩
     * 整个移动的过程就像是【毛毛虫爬行】
     */
    public static int minSubArrayLen(int target, int[] nums) {
        int sum = 0; // 代表窗口内最大值
        int left = 0;
        int minSize = Integer.MAX_VALUE;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= target) { // 达到条件了
                minSize = Math.min(minSize, right - left + 1);
                sum -= nums[left++]; // left 可以尝试缩短窗口了
            }
        }
        // 如果整个数组加起来都小于 target，就返回 0，因为 while 的条件进不去就不能给 minSize 赋值
        return minSize == Integer.MAX_VALUE ? 0 : minSize; // 就差这个判断
    }
}
