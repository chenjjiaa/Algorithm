package com.chenjjia.算法.LeetCode;

import com.chenjjia.算法.LeetCode.structure.ListNode;
import com.chenjjia.算法.LeetCode.structure.TreeNode;

/**
 * Author：  chenjunjia
 * Date：    2022/11/19 11:59
 * WeChat：  China_JoJo_
 * Blog：    https://juejin.cn/user/1856417285289304/posts
 * Github：  https://github.com/chenjjiaa
 *
 * LeetCode：https://leetcode.cn/problems/invert-binary-tree/
 * 难度：easy
 */
public class A226_翻转二叉树 {

    /**
     递归方法：一般使用前序、后序
     至于中序，需要注意一些小细节
     */
    public TreeNode invertTree(TreeNode node) {
        if (node == null) return node;
        swap(node);
        invertTree(node.left);
        invertTree(node.right);
        return node;
    }

    // 交换节点的左右孩子
    private void swap(TreeNode node) {
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
    }
}
