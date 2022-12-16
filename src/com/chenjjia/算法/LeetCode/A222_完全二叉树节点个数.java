package com.chenjjia.算法.LeetCode;

import com.chenjjia.算法.LeetCode.structure.TreeNode;

/**
 * Author：  chenjunjia
 * Date：    2022/10/21 22:41
 * WeChat：  China_JoJo_
 * Blog：    https://juejin.cn/user/1856417285289304/posts
 * Github：  https://github.com/chenjjiaa
 *
 * 求完全二叉树节点的个数
 *
 * P27 59分36秒
 * LeetCode 222（中等）. 完全二叉树的节点个数
 */

/**
 * 自己能够想出来了，先层数，后二分
 */
public class A222_完全二叉树节点个数 {

    // 时间复杂度：O(log n) 利用完全二叉树特性
    public int countNodes(TreeNode root) {
        if(root == null)
            return 0;
        return process(root, getHeight(root, 1), 1);
    }

    /**
     * 以 node 节点为头，求所有节点个数
     * @param node      以这个 node 为头
     * @param height    整棵树的总高度，固定变量
     * @param curLevel  node 所在的当前层
     */
    public int process(TreeNode node, int height, int curLevel) {
        if (curLevel == height) return 1;
        // 妙就妙在通过层数的控制，就不用对 node 做判空处理了
        // 如果右树的高度等于树的高度，直接结算左树，右树不一定满
        if (getHeight(node.right, curLevel+1) == height) {
            return (1 << (height - curLevel)) + process(node.right, height, curLevel+1);
        } else {
            // 如果右树高度小于树的高度，则右树必然是满的，于是可以直接结算右树，而左树不一定满
            return (1 << (height - curLevel - 1)) + process(node.left, height, curLevel+1);
        }
    }

    public int getHeight(TreeNode node, int curLevel) {
        while (node != null) {
            curLevel++;
            node = node.left;
        }
        return curLevel - 1;
    }

    // 时间复杂度：O(n) 未利用完全二叉树特性
    public int countNodes1(TreeNode root) {
        if(root == null) {
            return 0;
        }
        // 这里是后序遍历的简写
        return countNodes1(root.left) + countNodes1(root.right) + 1;
    }
}
