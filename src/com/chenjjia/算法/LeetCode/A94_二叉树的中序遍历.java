package com.chenjjia.算法.LeetCode;

import com.chenjjia.算法.LeetCode.structure.TreeNode;

import java.util.*;

/**
 * Author：  chenjunjia
 * Date：    2022/11/19 13:37
 * WeChat：  China_JoJo_
 * Blog：    https://juejin.cn/user/1856417285289304/posts
 * Github：  https://github.com/chenjjiaa
 *
 * LeetCode：https://leetcode.cn/problems/binary-tree-inorder-traversal/
 */

/**
 * 遍历难度：（非递归方式）
 * 前序最简单、其次后序、中序最繁琐
 */
public class A94_二叉树的中序遍历 {

    /**
     * 递归解
     */
    List<Integer> ans = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return ans;
        process(root);
        return ans;
    }
    public void process(TreeNode root) {
        if (root == null) return;
        process(root.left);
        ans.add(root.val);
        process(root.right);
    }
}
