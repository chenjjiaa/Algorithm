package com.chenjjia.算法.LeetCode;

import java.util.*;

/**
 * Author：  chenjunjia
 * Date：    2022/11/17 14:47
 * WeChat：  China_JoJo_
 * Blog：    https://juejin.cn/user/1856417285289304/posts
 * Github：  https://github.com/chenjjiaa
 */
public class A78_子集 {

    /**
     子集，就类似组合，只不过组合长度是从 0 ~ nums.length 而已

     和组合的区别是：
     组合是在叶子结点得到答案
     子集是从每一个结点去获取答案
     所以要在【每一层递归】中去收获答案
     是在 base case 之前收集答案

     这题甚至可以不写base case，但初学回溯，还是建议按照正常的流程来coding
     */

    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        backtracking(nums, 0);
        return ans;
    }

    public void backtracking(int[] nums, int startIndex) {
        ans.add(new ArrayList<Integer>(path)); // 在此处收集结果！！！
        if (startIndex >= nums.length) { // 终止条件可以不加，因为进不去for循环，走完代码就return了
            return;
        }
        for (int i = startIndex; i < nums.length; i++) {
            path.add(nums[i]);
            backtracking(nums, i+1);
            path.remove(path.size()-1);
        }
    }
}
