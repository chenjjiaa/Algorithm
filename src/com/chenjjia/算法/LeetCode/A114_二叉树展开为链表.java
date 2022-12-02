package com.chenjjia.算法.LeetCode;

import com.chenjjia.算法.LeetCode.structure.TreeNode;

import java.util.LinkedList;

/**
 * Author：  chenjunjia
 * Date：    2022/11/27 23:59
 * WeChat：  China_JoJo_
 * Blog：    https://juejin.cn/user/1856417285289304/posts
 * Github：  https://github.com/chenjjiaa
 *
 * LeetCode：https://leetcode.cn/problems/flatten-binary-tree-to-linked-list/
 * 难度：mid
 */
public class A114_二叉树展开为链表 {

    /**
     * 自己 A 了，看了下题解，一模一样的思路
     * 先序遍历，也是题目要求。将所有节点装入队列中
     * 遍历完毕返回队列，然后在主函数中，将队列的节点取出来，用来更改根节点
     */
    LinkedList<TreeNode> list = new LinkedList<>();
    public void flatten(TreeNode root) {
        if (root == null) return;
        if (root.left == null && root.right == null) return;
        preTraversal(root);
        while (!list.isEmpty()) {
            root.left = null;
            root.right = list.pollFirst();
            root = root.right;
        }
    }

    public void preTraversal(TreeNode node) {
        if (node == null) return;
        list.addLast(node);
        preTraversal(node.left);
        preTraversal(node.right);
    }
}
