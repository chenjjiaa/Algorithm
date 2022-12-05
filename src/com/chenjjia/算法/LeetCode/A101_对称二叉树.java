package com.chenjjia.算法.LeetCode;

import com.chenjjia.算法.LeetCode.structure.TreeNode;

/**
 * Author：  chenjunjia
 * Date：    2022/11/19 15:01
 * WeChat：  China_JoJo_
 * Blog：    https://juejin.cn/user/1856417285289304/posts
 * Github：  https://github.com/chenjjiaa
 */
public class A101_对称二叉树 {

    /**
     递归 后序
     为什么使用后序？因为后序的顺序是 左右中
     要拿到左右孩子的信息返回给中，才能进行比较

     大体思路是：将左边孩子处理完、再将右边孩子处理完
     最后才通过中间节点来比较两侧孩子节点的信息

     什么题型适合后序遍历？
     如果遇到需要向左孩子要信息、再向右孩子要信息，向上一层返回
     这一类题型需要使用后序遍历
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        // 从根节点传入，得到两个子树的信息
        return compare(root.left, root.right);
    }

    public boolean compare(TreeNode n1, TreeNode n2) {
        if (n1 == null && n2 == null) return true;
        if (n1 != null && n2 == null) return false;
        if (n1 == null && n2 != null) return false;
//        if (n1.val == n2.val) return true;
        if (n1.val != n2.val) return false; // 就算两个值相等，也不能直接返回true，因为还要接着往下继续遍历！

        // 向左树要信息，往左递归
        boolean outsize = compare(n1.left, n2.right);
        // 向右树要信息，往右递归
        boolean insize = compare(n1.right, n2.left);
        // 中间节点处理左右节点信息，这整个过程就是后序遍历
        // 在这里可以直接返回
        return outsize && insize;
    }
}
