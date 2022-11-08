package com.chenjjia.算法.图;

import com.chenjjia.算法.图.结构.Graph;
import com.chenjjia.算法.图.结构.Node;

import java.util.*;

/**
 * Author：  chenjunjia
 * Date：    2022/8/4 15:31
 * WeChat：  China_JoJo_
 */
public class 拓扑排序问题 {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.nexts.add(node2);
        node1.nexts.add(node3);
        node2.nexts.add(node3);
        node2.nexts.add(node4);
        node3.nexts.add(node4);

        Graph graph = new Graph();
        graph.nodes.put(1,node1);
        graph.nodes.put(2,node2);
        graph.nodes.put(3,node3);
        graph.nodes.put(4,node4);

        for (Node node: sortedTopology(graph)) {
            System.out.println(node.value);
        }
    }

    /**
     * 拓扑排序
     * 要求图无环（有环代表循环依赖了）
     * 思路：先将入度为 0 的节点输出，然后消除掉此节点影响的节点
     *      从而生成新的入度为 0 的节点，循环即可
     */
    public static List<Node> sortedTopology(Graph graph) {
        HashMap<Node,Integer> inMap = new HashMap<>(); // HashMap<Node, 剩余的入度>
        Queue<Node> zeroInQueue = new LinkedList<>(); // 只有入度为 0，才能进入这个队列
        // 将入度为 0 的节点添加到队列中
        for (Node node : graph.nodes.values()) {
            inMap.put(node,node.in);
            if (node.in == 0) {
                zeroInQueue.add(node);
            }
        }
        // 返回排序好的结果集
        ArrayList<Node> resultList = new ArrayList<>();
        while (!zeroInQueue.isEmpty()) {
            Node cur = zeroInQueue.poll();
            resultList.add(cur);
            // 遍历节点的 nexts，消除入度为 0 的节点的影响
            for (Node node : cur.nexts) {
                // 修改入度
                inMap.put(node, inMap.get(node) - 1);
                if (inMap.get(node) == 0) {
                    // 将新的入度为 0 的节点添加到队列
                    zeroInQueue.add(node);
                }
            }
        }
        return resultList;
    }
}