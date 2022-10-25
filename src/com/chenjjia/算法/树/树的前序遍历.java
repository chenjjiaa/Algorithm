package com.chenjjia.算法.树;

import java.util.Stack;

/**
 * Author：  chenjunjia
 * Date：    2022/8/1 16:57
 * WeChat：  China_JoJo_
 */

/**
 * 注意：二叉树的 深度遍历 就是 前序遍历
 */
public class 树的前序遍历 {
    public static void main(String[] args) {
        Node root        =  new Node(1);
        root.left        =  new Node(2);
        root.right       =  new Node(3);
        root.left.left   =  new Node(4);
        root.left.right  =  new Node(5);
        root.right.left  =  new Node(6);
        root.right.right =  new Node(7);
        preOrderTraversal1(root);
    }

    /**
     * 前序遍历，递归方式
     * 思路是：每个节点都会进入此方法三次，在三次来到此方法时，选择合适的时机输出，来达到前中后序遍历效果
     */
    public static void preOrderTraversal1(Node root) {
        if (root == null) {
            return;
        }
        System.out.println(root.value); // 只在第一次进入此节点的时候打印它的值
        preOrderTraversal1(root.left);
        preOrderTraversal1(root.right);
    }

    /**
     * 非递归方式
     * 步骤：1、将根节点压入栈中
     *      2、打印根节点
     *      3、将根节点的右孩子压入栈中（如果有）
     *      4、将根节点的左孩子压入栈中（如果有）
     *      5、循环至栈空则停止
     */
    public static void preOrderTraversal2(Node root) {
        Stack<Node> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            System.out.println(cur.value);
            if (cur.right != null) {
                stack.add(cur.right);
            }
            if (cur.left != null) {
                stack.add(cur.left);
            }
        }

    }

    public static class Node {
        private int value;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
        }
    }
}
