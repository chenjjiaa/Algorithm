package com.chenjjia.算法.LeetCode;

import com.chenjjia.算法.LeetCode.structure.TreeNode;

/**
 * Author：  chenjunjia
 * Date：    2022/11/18 23:27
 * WeChat：  China_JoJo_
 * Blog：    https://juejin.cn/user/1856417285289304/posts
 * Github：  https://github.com/chenjjiaa
 *
 * LeetCode：https://leetcode.cn/problems/house-robber-iii/
 * 这题是员工最大快乐值的 low 版，左神有讲过 员工最大快乐值，多叉树暴力递归
 */
public class A337_打家劫舍III {

    /**
     * 暴力递归
     * DFS
     */
    public int rob(TreeNode root) {
        Info info = process(root);
        return Math.max(info.robMax, info.notRobMax);
    }

    public Info process(TreeNode root) {
        if (root == null) {
            return new Info(0, 0);
        }

        // 设置本层的 robMax、notRobMax
        int robMax = root.val;
        int notRobMax = 0;

        // 往下递归
        // 这个过程其实可以看成是回溯中的 for 循环
        // 只不过没有回溯的操作，这个是 DFS
        Info left = process(root.left);
        Info right = process(root.right);

        robMax += left.notRobMax;
        robMax += right.notRobMax;
        notRobMax += Math.max(left.robMax, left.notRobMax);
        notRobMax += Math.max(right.robMax, right.notRobMax);

        return new Info(robMax, notRobMax);
    }

    private static class Info {
        int robMax;
        int notRobMax;
        public Info(int robMax, int notRobMax) {
            this.robMax = robMax;
            this.notRobMax = notRobMax;
        }
    }
}
