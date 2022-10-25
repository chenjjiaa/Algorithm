package com.chenjjia.算法.图;

import com.chenjjia.算法.图.结构.Node;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Author：  chenjunjia
 * Date：    2022/8/4 12:50
 * WeChat：  China_JoJo_
 *
 * BFS：广度优先算法（Breadth First Search）
 */
public class 图的广度优先遍历 {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.nexts.add(node3);
        node2.nexts.add(node3);
        node3.nexts.add(node4);

        breadthFirstSearch(node1);
    }

    /**
     * 广度优先遍历
     *
     * 只传入点的广度遍历有缺陷。
     * 比如：1-->3，2-->3，3-->4
     *     传入 1，只会输出 1  3  4
     */
    public static void breadthFirstSearch(Node node) {
        if (node == null) {
            return;
        }
        HashSet<Node> set = new HashSet<>(); // set 是保证点不重复，避免了一些有环的有向图，以及无向图无限循环的问题
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        set.add(node);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            // 宽度优先处理的时候，就把打印行为改成处理行为即可
            System.out.println(cur.value);
            for (Node node1 : cur.nexts) {
                if (!set.contains(node1)) {
                    queue.add(node1);
                    set.add(node1);
                }
            }
        }
    }
}
