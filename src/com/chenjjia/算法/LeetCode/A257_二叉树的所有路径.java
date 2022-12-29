package com.chenjjia.算法.LeetCode;

import com.chenjjia.算法.LeetCode.structure.TreeNode;

import java.util.*;

/**
 * Author：  chenjunjia
 * Date：    2022/11/19 21:28
 * WeChat：  China_JoJo_
 * Blog：    https://juejin.cn/user/1856417285289304/posts
 * Github：  https://github.com/chenjjiaa
 */
public class A257_二叉树的所有路径 {
    public static void main(String[] args) {
        List list = new ArrayList(new HashSet());
        System.out.println(list);
    }

    /**
     * 树的回溯，手动模拟了两次 for 循环
     * 难点是：没有了 startIndex 的控制，会导致元素重复
     */
    List<String> ans = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) return ans;
        backtracking(root, "");
        return ans;
    }

    public void backtracking(TreeNode node, String path) {
        if (node == null) {
            return;
        }
        StringBuilder sb = new StringBuilder(path);
        sb.append(node.val); // ② 因为从后往前看，当前节点是在 "->" 添加之后添加的
        if (node.left == null && node.right == null) {
            // 收集结果的时候
            ans.add(sb.toString());
            return;
        }
        // ① 如果后面不是空节点，"->" 才会算进去，所以即时是空，后面也不会添加进 ans
        sb.append("->");
        backtracking(node.left, sb.toString()); // 包含了回溯过程
        backtracking(node.right, sb.toString());
    }
}
