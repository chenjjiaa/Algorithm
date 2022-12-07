package com.chenjjia.算法.LeetCode;

import com.chenjjia.算法.LeetCode.structure.TreeNode;

/**
 * Author：  chenjunjia
 * Date：    2022/11/19 17:03
 * WeChat：  China_JoJo_
 * Blog：    https://juejin.cn/user/1856417285289304/posts
 * Github：  https://github.com/chenjjiaa
 *
 * LeetCode：https://leetcode.cn/problems/maximum-depth-of-binary-tree/
 * 难度：easy
 *
 * 这题，代码随想录的扩展知识讲得不错
 * https://www.bilibili.com/video/BV1Gd4y1V75u/?spm_id_from=333.788&vd_source=72ad5c1392d035e00c5326eb4487626b
 */
public class A104_二叉树的最大深度 {

    /**
     * 这里要注意一下【深度】和【高度】的区别
     * 区别在于：
     *     高度是每个节点离叶子节点的距离，叶子节点高度为 1
     *     深度是从根节点出发，每向下一层，深度 +1
     * 而且遍历方式也有区别
     *     求高度一般采用：后序遍历，即根节点取左树和右树的返回值，比较后 +1
     *     求深度一般采用：前序遍历，每往下时就 +1
     *
     * 注：整棵树的高度和深度是相等的，只不过在方向上、遍历方式上不太一样
     *
     * 在这里会注意到，这个方法不就是左神的二叉树递归套路吗？
     * 向左树要信息，向右树要信息，然后整合返回！
     */
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return process(root);
    }

    // 这里采用后序遍历的方式，以求高度的方式获取整棵树的最大深度
    public int process(TreeNode node) {
        if (node == null) return 0;
        int leftMax = process(node.left);
        int rightMax = process(node.right);
        return Math.max(leftMax, rightMax) + 1;
    }
}
