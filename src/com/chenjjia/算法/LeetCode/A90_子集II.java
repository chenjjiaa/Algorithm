package com.chenjjia.算法.LeetCode;

import java.util.*;

/**
 * Author：  chenjunjia
 * Date：    2022/11/17 15:26
 * WeChat：  China_JoJo_
 * Blog：    https://juejin.cn/user/1856417285289304/posts
 * Github：  https://github.com/chenjjiaa
 */
public class A90_子集II {
    public static void main(String[] args) {

    }

    /**
     本题要做到一个 “树的同层去重”
     和 40 组合总和II 类似
     但去重要注意要排序
     */
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        ans.add(new ArrayList<>());
        Arrays.sort(nums);
        backtracking(nums, 0, new byte[nums.length]);
        return ans;
    }

    public void backtracking(int[] nums, int start, byte[] used) {
        for (int i = start; i < nums.length; i++) {
            /**
             i > 0 是为了保证 nums[i-1] 不越界
             nums[i] == nums[i-1] 是验证排序后数组上一个相同数字是不是出现过
             used[i-1] == 0 是验证上次使用过了且回溯了，那本层就别再用了
             */
            if (i > 0 && nums[i] == nums[i-1] && used[i-1] == 0) {
                continue;
            } else {
                path.add(nums[i]);
                ans.add(new ArrayList<>(path));
                used[i] = 1;
                backtracking(nums, i+1, used);
                path.remove(path.size()-1);
                used[i] = 0;
            }
        }
    }
}
