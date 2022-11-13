package com.chenjjia.算法.LeetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Author：  chenjunjia
 * Date：    2022/11/12 22:20
 * WeChat：  China_JoJo_
 * Blog：    https://juejin.cn/user/1856417285289304/posts
 * Github：  https://github.com/chenjjiaa
 */
public class A236_二叉树的最近公共祖先 {
    public static void main(String[] args) {
        TreeNode root =     new TreeNode(1);
        root.left        =  new TreeNode(2);
        root.right       =  new TreeNode(3);
        root.left.left   =  new TreeNode(4);
        root.left.right  =  new TreeNode(5);
        root.right.left  =  new TreeNode(6);
        root.right.right =  new TreeNode(7);

        System.out.println(lowestCommonAncestor2(root, root.left.left, root.right.left).val);
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        HashMap<TreeNode, TreeNode> fatherMap = new HashMap<>();
        fatherMap.put(root, root);
        process(root, fatherMap);
        // 获取 p 沿途的所有节点（一直到根节点）
        Set<TreeNode> set1 = new HashSet<>();
        set1.add(p);
        TreeNode cur = p;
        while (cur != root) {
            set1.add(fatherMap.get(cur));
            cur = fatherMap.get(cur); // 一直往上窜
        } // 循环结束之后，得到一条 p 节点一直向上到根节点的链子

        TreeNode cur2 = q;
        while (!set1.contains(cur2)) { // 如果 cur2 在 set1 里，则此时 cur2 就是最近的公共的节点
            cur2 = fatherMap.get(cur2); // 一直往上窜
        }
        return cur2;
    }

    // 递归生成每个节点的父节点
    public static void process(TreeNode root, HashMap<TreeNode, TreeNode> fatherMap) {
        if (root == null) { // 孩子为空，就不put进map了
            return;
        }
        fatherMap.put(root.left, root);
        fatherMap.put(root.right, root);
        process(root.left, fatherMap);  // 向左孩子递归
        process(root.right, fatherMap); // 向右孩子递归
    }

    public static TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor2(root.left, p, q);
        TreeNode right = lowestCommonAncestor2(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        return left == null ? right : left;
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
