package com.chenjjia.算法.LeetCode;

import java.util.*;

/**
 * Author：  chenjunjia
 * Date：    2022/11/17 1:29
 * WeChat：  China_JoJo_
 * Blog：    https://juejin.cn/user/1856417285289304/posts
 * Github：  https://github.com/chenjjiaa
 */
public class A40_组合总和II {
    public static void main(String[] args) {

    }

    /**
     与之前不同的是：这题 int[] candidates 给的数据可能会重复
     */
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null) {
            return ans;
        }
        Arrays.sort(candidates);
        backtracking(candidates, target, 0, 0, new byte[candidates.length]);
        return ans;
    }

    public void backtracking(int[] candidates, int target, int sum, int startIndex, byte[] used) {
        if (sum >= target) {
            if (sum == target)
                ans.add(new ArrayList<>(path));
            return;
        }
        /**
         出现的问题是：candidates可能会出现相同的数，所以遇到相同的数字，要跳过此次循环
         将 candidates 放进 set 很显然不是一个好的做法
         我们要做的是在同一树层上去重，而同一树枝上的不用去重
         可以利用 used[] 数组去重（在“排列”内容中会讲到）

         疑惑：但为什么是 used[i - 1] == 0 现在还有点费解  # ----------2022年11月17日01:24:06

         解释：之所以为什么是 used[i - 1] == 0 主要就是为了去除 “本层” 的重复  # ----------2022年11月17日01:26:14
         而 used[i] == 1 这个是在树枝反向的限制（“排列”内容）
         之所以要 i-1 = 0 是因为回溯会将本层的操作重置，到下一次循环就会重置了，而 i-1 是排序后的普遍规律

         比如：target = 3， candidates = {1,1,2,3,4} （sort后）
         可以选择：  0位置的1 与 2位置的2  ----> 添加到ans，ans.add(1,2)
                    1位置的1 与 2位置的2  ----> 添加到ans，ans.add(1,2)
         于是产生了重复
         */
        for (int i = startIndex; i < candidates.length; i++) {
            if (target - sum - candidates[i] < 0) // 剪枝操作
                return;
            if (i > 0 && candidates[i] == candidates[i-1] && used[i - 1] == 0) { // 如果遇到了和上次相同的数，continue
                continue;
            }
            used[i] = 1;
            sum += candidates[i];
            path.add(candidates[i]);
            backtracking(candidates, target, sum, i+1, used);
            sum -= candidates[i];
            path.remove(path.size() - 1);
            used[i] = 0;
        }
    }
}
