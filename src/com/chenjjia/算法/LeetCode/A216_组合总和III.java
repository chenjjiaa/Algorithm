package com.chenjjia.算法.LeetCode;

import java.util.*;

/**
 * Author：  chenjunjia
 * Date：    2022/11/16 14:43
 * WeChat：  China_JoJo_
 * Blog：    https://juejin.cn/user/1856417285289304/posts
 * Github：  https://github.com/chenjjiaa
 */
public class A216_组合总和III {
    public static void main(String[] args) {

    }

    public static List<List<Integer>> combinationSum3(int k, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if (k > target) {
            return ans;
        }
        backtracking(k, target, ans, new ArrayList<>(), 0, 1);
        return ans;
    }

    /**
     * 本题剪枝操作就是，如果 sum 比 target 的大，那么再选后面的就无意义了
     */
    public static void backtracking(int k, int target, List<List<Integer>> ans, List<Integer> path, int sum, int startIndex) {
        if (path.size() == k) {
            if (sum == target)
                ans.add(new ArrayList<Integer>(path));
            return;
        }
        if (sum > target) return; // 剪枝操作，sum大于targe就没必要继续循环递归了

        // for (int i = startIndex; i <= 9; i++) { // for循环也可以剪枝
        for (int i = startIndex; i <= 9 - (k - path.size()) + 1; i++) {
            sum += i;
            path.add(i);
            backtracking(k, target, ans, path, sum, i+1); // 这里是 i+1 而不是 startIndex+1，去重操作
            sum -= i;
            path.remove(path.size()-1);
        }
    }
}
