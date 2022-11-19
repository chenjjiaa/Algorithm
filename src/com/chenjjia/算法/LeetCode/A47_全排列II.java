package com.chenjjia.算法.LeetCode;

import java.util.*;

/**
 * Author：  chenjunjia
 * Date：    2022/11/17 19:00
 * WeChat：  China_JoJo_
 * Blog：    https://juejin.cn/user/1856417285289304/posts
 * Github：  https://github.com/chenjjiaa
 */
public class A47_全排列II {
    /**
     这题的【树层去重】可以排序操作，但 491.递增子序列哪题不行
     因为子序列的元素之间，相对次序不能乱

     区别：
     排列中的 startIndex 可以从 0 开始，然后避开 used 数组中使用过的元素即可

     这题要控制树层和树枝的去重，究极叠加
     */
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        backtracking(nums, new byte[nums.length]);
        return ans;
    }

    public void backtracking(int[] nums, byte[] used) {
        if (path.size() == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            /**
             * used[i - 1] == 1，说明同一【树枝】nums[i - 1]使用过
             * used[i - 1] == 0，说明同一【树层】nums[i - 1]使用过
             * 如果同一树层nums[i - 1]使用过则直接跳过
             */
            if ((i > 0 && nums[i] == nums[i-1]) && used[i-1] == 0) { // 控制树层
                continue;
            }
            if (used[i] != 1) { // 控制树枝
                path.add(nums[i]);
                used[i] = 1;
                backtracking(nums, used);
                used[i] = 0;
                path.remove(path.size() - 1);
            }
        }
    }
}
