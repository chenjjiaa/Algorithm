package com.chenjjia.算法.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author：  chenjunjia
 * Date：    2022/11/12 15:25
 * WeChat：  China_JoJo_
 * Blog：    https://juejin.cn/user/1856417285289304/posts
 * Github：  https://github.com/chenjjiaa
 *
 * 给你一个整数数组 nums ，判断是否存在三元组
 * [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k
 * 同时还满足 nums[i] + nums[j] + nums[k] == 0
 * 请你返回所有和为 0 且不重复的三元组
 * 注意：答案中不可以包含重复的三元组
 *
 * LeetCode：https://leetcode.cn/problems/3sum/
 */
public class A15_三数之和 {
    public static void main(String[] args) {
        List<List<Integer>> lists = threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println();
    }

    /**
     * 三数之和可以套用两数之和的方案
     * 若 nums[i] + twoSum == 0，则得到其中一个结果
     *
     * 难点：如何去重
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length-1;
        int i = 0;
        List<List<Integer>> res = new ArrayList<>();

        for(; i <= len; i++) {
            if (nums[i] > 0) { // 如果 i 位置的数直接大于 0，那后面的数肯定大于 0 了，直接返回
                return res;
            }
            if (i > 0 && nums[i] == nums[i-1]) { // 不能有相同的三元组
                continue;
            }
            int left = i+1;
            int right = len;
            while (left < right) {
                int temp = nums[i] + nums[left] + nums[right];
                if (temp < 0) {
                    left++;
                }
                if (temp > 0) {
                    right--;
                }
                if (temp == 0) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (right > left && nums[left] == nums[left+1]) {
                        left++;
                    }
                    while (right > left && nums[right] == nums[right-1]) {
                        right--;
                    }
                    left++;
                    right--;
                }
            }
        }
        return res;
    }
}
