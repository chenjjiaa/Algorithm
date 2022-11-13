package com.chenjjia.算法.LeetCode;

import java.util.*;

/**
 * Author：  chenjunjia
 * Date：    2022/11/13 13:55
 * WeChat：  China_JoJo_
 * Blog：    https://juejin.cn/user/1856417285289304/posts
 * Github：  https://github.com/chenjjiaa
 *
 * LeetCode：https://leetcode.cn/problems/binary-tree-zigzag-level-order-traversal/comments/
 * 难度：mid
 */

/**
 * 就是在二叉树的层序遍历的基础上，加了个奇偶层 tag 判断而已，根据这个 tag 来做翻转
 */
public class A103_二叉树的锯齿形层序遍历 {
    public static void main(String[] args) {

    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return null;
        }
        int level = 1; // 初始化
        List<List<Integer>> res = new ArrayList<>(); // 要返回的大数组
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            // 看看本次要加多少个元素进小List
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode cur = queue.poll();
                list.add(cur.val); // 将本层节点加到小list中
                if (cur.left != null) {
                    queue.add(cur.left);  // 将下一层节点放入队列，在下一次循环加入小list
                }
                if (cur.right != null) {
                    queue.add(cur.right); // 将下一层节点放入队列，在下一次循环加入小list
                }
            }
            // 判断是否要翻转 List
            if ((level & 1) == 0) {
                Collections.reverse(list);
            }
            res.add(list);
            level++;
        }
        return res;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
}
