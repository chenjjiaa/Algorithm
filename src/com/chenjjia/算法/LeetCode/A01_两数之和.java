package com.chenjjia.算法.LeetCode;

import java.util.HashMap;

/**
 * Author：  chenjunjia
 * Date：    2022/11/11 23:02
 * WeChat：  China_JoJo_
 * Blog：    https://juejin.cn/user/1856417285289304/posts
 * Github：  https://github.com/chenjjiaa
 *
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * 你可以按任意顺序返回答案。
 *
 * 示例 ：
 * 输入：nums = [3,2,4], target = 6
 * 输出：[1,2]，因为 num[1] + num[2] = 6
 */
public class A01_两数之和 {
    public static void main(String[] args) {
        int[] ints = twoSum(new int[]{1, 2, 3, 4, 5}, 5);
        for (int i=0; i<ints.length; i++){
            System.out.print(ints[i] + "  ");
        }
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] res = {0};
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(nums[0], 0);
        for (int i = 1; i < nums.length; i++) {
            int temp = target - nums[i];
            if (map.containsKey(temp)) {
                res = new int[] {map.get(temp), i};
            }
            map.put(nums[i], i);
        }
        return res;
    }
}
