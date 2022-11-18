package com.chenjjia.算法.LeetCode;

import java.util.*;

/**
 * Author：  chenjunjia
 * Date：    2022/11/17 17:10
 * WeChat：  China_JoJo_
 * Blog：    https://juejin.cn/user/1856417285289304/posts
 * Github：  https://github.com/chenjjiaa
 *
 * LeetCode：https://leetcode.cn/problems/increasing-subsequences/
 */
public class A491_递增子序列 {
    /**
     除了要使用 used
     还要判断在每个节点该不该放入
     */
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        if (nums == null || nums.length == 0) return ans;
        backtracking(nums, 0);
        return ans;
    }

    public void backtracking(int[] nums, int start) {
        if (path.size() > 1) // 题目要求长度是2起步
            ans.add(new ArrayList<>(path));

        // 埋个伏笔，这里set也可以用别的方式代替，比如用数组效率也会高一些
        HashSet<Integer> set = new HashSet<>();
        for (int i = start; i < nums.length; i++) {
            if (set.contains(nums[i]) || (!path.isEmpty() && (nums[i] < path.get(path.size() - 1)))){
                continue; // 因为后面可能还有更大的数字，不能把后面的都砍掉
            } else {
                set.add(nums[i]);
                path.add(nums[i]);
                backtracking(nums, i+1);
                path.remove(path.size()-1);
            }
        }
    }
}
