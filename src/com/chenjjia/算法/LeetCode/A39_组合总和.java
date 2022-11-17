package com.chenjjia.算法.LeetCode;

import java.util.*;

/**
 * Author：  chenjunjia
 * Date：    2022/11/17 0:49
 * WeChat：  China_JoJo_
 * Blog：    https://juejin.cn/user/1856417285289304/posts
 * Github：  https://github.com/chenjjiaa
 */
public class A39_组合总和 {

    /**
     这题又和前面的一些题不一样
     主要是本层选择完之后，下一层还可以继续选从本层 startIndex 开始的元素
     因为本题涉及了一个重复选
     */
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null)
            return ans;
        Arrays.sort(candidates);
        backtracking(candidates, target, 0, 0);
        return ans;
    }

    public void backtracking(int[] candidates, int target, int startIndex, int sum) {
        if (sum >= target) {
            if (target == sum)
                ans.add(new ArrayList<>(path));
            return;
        }
        /**
         这里 i 的限制条件突然有点想不起来，其实就是要小于可选择的 “项”
         而这题的每一项可供选择的元素就是 candidates.length
         */
        for(int i = startIndex; i < candidates.length; i++) {
            // 剪枝操作，针对的是排完序的情况，如果后面的数加起来都大于 target，那就没必要继续了
            if (target - sum - candidates[i] < 0)
                return;
            sum += candidates[i]; // 这个相当于 used 一样是一个使用判断条件
            path.add(candidates[i]); // path差不多是必须的
            backtracking(candidates, target, i, sum); // 因为可以重复选择，所以i不能+1
            sum -= candidates[i];
            path.remove(path.size()-1);
        }
    }
}
