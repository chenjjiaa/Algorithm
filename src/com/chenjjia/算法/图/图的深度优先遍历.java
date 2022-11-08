package com.chenjjia.算法.图;

import com.chenjjia.算法.图.结构.Node;

import java.util.HashSet;
import java.util.Stack;

/**
 * Author：  chenjunjia
 * Date：    2022/8/4 12:49
 * WeChat：  China_JoJo_
 *
 * DFS：深度优先算法（Depth First Search）
 */
public class 图的深度优先遍历 {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);

        node1.nexts.add(node2);
        node1.nexts.add(node3);
        node1.nexts.add(node4);
        node3.nexts.add(node5);
        node4.nexts.add(node6);

        depthFirstSearch(node1);
    }

    /**
     * 深度优先遍历
     */
    public static void depthFirstSearch(Node node) {
        if (node == null) {
            return;
        }
        HashSet<Node> set = new HashSet<>();
        Stack<Node> stack = new Stack<>();
        stack.push(node);
        System.out.println(node.value); // 在外面先输出一次

        while (!stack.isEmpty()) {
            Node cur = stack.pop();

            for (Node next : cur.nexts) {
                if (!set.contains(next)) {
                    set.add(next);
                    stack.push(cur);
                    stack.push(next);
                    System.out.println(next.value);
                    break; // 跳出本层循环
                }
            }
        }
    }
}