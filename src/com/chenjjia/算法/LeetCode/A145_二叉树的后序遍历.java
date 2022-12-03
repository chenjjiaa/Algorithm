package com.chenjjia.算法.LeetCode;

import com.chenjjia.算法.LeetCode.structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Author：  chenjunjia
 * Date：    2022/11/19 14:02
 * WeChat：  China_JoJo_
 * Blog：    https://juejin.cn/user/1856417285289304/posts
 * Github：  https://github.com/chenjjiaa
 */

/**
 * 遍历难度：（非递归方式）
 * 前序最简单、其次后序、中序最繁琐
 */
public class A145_二叉树的后序遍历 {

    /**
     * 递归解法
     */
    List<Integer> ans = new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) return ans;
        process(root);
        return ans;
    }

    public void process(TreeNode node) {
        if (node == null) return;
        process(node.left);
        process(node.right);
        ans.add(node.val);
    }
}
