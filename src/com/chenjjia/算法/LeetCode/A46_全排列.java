package com.chenjjia.算法.LeetCode;

import java.util.*;

/**
 * Author：  chenjunjia
 * Date：    2022/11/14 1:22
 * WeChat：  China_JoJo_
 * Blog：    https://juejin.cn/user/1856417285289304/posts
 * Github：  https://github.com/chenjjiaa
 */

/**
 * DFS 回溯算法
 * DFS 在回到上一层节点需要 “状态重置”，也就是要撤销掉上次的选择，进行重新选择
 * 树形深度优先遍历就是大名鼎鼎的 “回溯算法”
 * “状态重置” 就是回溯算法里回溯的意思
 * 递归层数 = 输入数组的长度，那么到了最后一层，就是递归终止的条件
 */
public class A46_全排列 {
    public static void main(String[] args) {

    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        byte[] used = new byte[nums.length];
        Deque<Integer> path = new ArrayDeque<>();
        process(nums, path, used, res);
        return res;
    }

    public static void process(int[] nums, Deque<Integer> path, byte[] used, List<List<Integer>> res) {
        if (path.size() == nums.length) { // 如果完成了选择，将这次选择添加到结果集中
            res.add(new ArrayList<>(path)); // 因为path之后还要用，所以拷贝一个新对象进去
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(used[i] == 1) continue;
            used[i] = 1;
            path.addLast(nums[i]);
            process(nums, path, used, res);
            // 回溯要记得重置状态位
            used[i] = 0;
            path.removeLast();
        }
    }
}
