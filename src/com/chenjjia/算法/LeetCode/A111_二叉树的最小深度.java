package com.chenjjia.算法.LeetCode;

import com.chenjjia.算法.LeetCode.structure.TreeNode;

/**
 * Author：  chenjunjia
 * Date：    2022/11/19 17:20
 * WeChat：  China_JoJo_
 * Blog：    https://juejin.cn/user/1856417285289304/posts
 * Github：  https://github.com/chenjjiaa
 *
 * LeetCode：https://leetcode.cn/problems/minimum-depth-of-binary-tree/
 */
public class A111_二叉树的最小深度 {

    /**
     * 这题有踩坑点：根节点离叶子节点的距离才算是最小深度
     * 比如，如果根节点本身没有左孩子，只有右孩子的话，很容易误判成 最小深度为 1
     *
     * 极端点的例子，一棵树可能只有一个分支，也就是一直都是左孩子一条线窜下去
     * 这个时候用上次那种 Math.min() + 1 那就是行不通的
     *
     * 我们要做的是在递归过程做一个左右孩子的判空操作
     */
    public int minDepth(TreeNode root) {
        return process(root);
    }

    // 同样采用后序
    public int process(TreeNode node) {
        if (node == null)
            return 0;
        /**
         * ****** 啰嗦版本 ******
         * if (node.left != null && node.right == null)
         *     return process(node.left) + 1; // 别忘了 +1
         * if (node.left == null && node.right != null)
         *     return process(node.right) + 1; // 别忘了 +1
         * if (node.left != null && node.right != null) // 如果左右都有孩子，那就是正常情况，这里就写精简版就行了
         *     return Math.min(process(node.left), process(node.right)) + 1;
         * if (node.left == null && node.right == null) // 此时为叶子节点
         *     return 1;
         * return 0;
         */

        // 正常的后序写法【不精简】目的是熟悉流程
        int leftMin = process(node.left);       // 左
        int rightMin = process(node.right);     // 右
                                                // 中 ↓ 处理左右孩子返回结果
        // 当一个左子树不为空，右为空，这里此时并不是最低点
        if (node.left != null && node.right == null) {
            return leftMin + 1;
        }
        // 当一个右子树为空，左不为空，这里此时并不是最低点
        if (node.left == null && node.right != null) {
            return rightMin + 1;
        }
        return Math.min(leftMin, rightMin) + 1;
    }
}
