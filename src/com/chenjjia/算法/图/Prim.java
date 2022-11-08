package com.chenjjia.算法.图;

import com.chenjjia.算法.图.结构.Edge;
import com.chenjjia.算法.图.结构.EdgeComparator;
import com.chenjjia.算法.图.结构.Graph;
import com.chenjjia.算法.图.结构.Node;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * Author：  chenjunjia
 * Date：    2022/8/5 9:24
 * WeChat：  China_JoJo_
 *
 * Prim算法是最小生成树算法：保证整个图的连通性，但所有边的权值加起来最小
 * Prim算法针对无向图
 */
public class Prim {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        Edge edge1 = new Edge(10,node1,node2);
        Edge edge2 = new Edge(100,node1,node3);
        Edge edge3 = new Edge(3,node3,node4);
        Edge edge4 = new Edge(7,node1,node4);
        Edge edge5 = new Edge(20,node2,node4);

        Edge edge6 = new Edge(10,node2,node1);
        Edge edge7 = new Edge(100,node3,node1);
        Edge edge8 = new Edge(3,node4,node3);
        Edge edge9 = new Edge(7,node4,node1);
        Edge edge10 = new Edge(20,node4,node2);

        Graph graph = new Graph();
        graph.nodes.put(1,node1);
        graph.nodes.put(2,node2);
        graph.nodes.put(3,node3);
        graph.nodes.put(4,node4);

        graph.edges.add(edge1);
        graph.edges.add(edge2);
        graph.edges.add(edge3);
        graph.edges.add(edge4);
        graph.edges.add(edge5);
        graph.edges.add(edge6);
        graph.edges.add(edge7);
        graph.edges.add(edge8);
        graph.edges.add(edge9);
        graph.edges.add(edge10);

        node1.edges.add(edge1);
        node1.edges.add(edge2);
        node1.edges.add(edge4);
        node2.edges.add(edge5);
        node2.edges.add(edge6);
        node3.edges.add(edge3);
        node3.edges.add(edge7);
        node4.edges.add(edge8);
        node4.edges.add(edge9);
        node4.edges.add(edge10);

        node1.nexts.add(node2);
        node1.nexts.add(node3);
        node1.nexts.add(node4);
        node2.nexts.add(node1);
        node2.nexts.add(node4);
        node3.nexts.add(node1);
        node3.nexts.add(node4);
        node4.nexts.add(node1);
        node4.nexts.add(node2);
        node4.nexts.add(node3);


        for (Edge edge : primMST(graph)) {
            System.out.println(edge.weight);
        }
    }

    public static Set<Edge> primMST(Graph graph) {
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(new EdgeComparator()); // 将边放入小根堆中
        Set<Node> nodeSet = new HashSet<>(); // 用来放已经用过的点
        Set<Edge> resultSet = new HashSet<>(); // 放返回的边
        /**
         * 这最外层 for 循环是处理森林的问题，在 kruskal算法中需要考虑：
         * 即一个孤立的点集与另一个孤立的点集链接的问题，但在prim算法中其实也不太需要，作为预防吧
         * 若一开始就认为整个图是连通的，那靠下面的 if 就可以完成此算法
         */
        for (Node node : graph.nodes.values()) {
            // 随机从一个 node 开始
            if (!nodeSet.contains(node)) {
                // 加点
                nodeSet.add(node);
                // 将点的边加到小根堆
                for (Edge edge : node.edges) {
                    priorityQueue.add(edge);
                }
                while (!priorityQueue.isEmpty()) {
                    Edge edge = priorityQueue.poll(); // 弹出解锁的边中最小的边
                    Node toNode = edge.to; // 获取这条边连接的点
                    if (!nodeSet.contains(toNode)) {
                        nodeSet.add(toNode);
                        resultSet.add(edge); // 添加到返回结果
                        for (Edge nextEdge : toNode.edges) {
                            priorityQueue.add(nextEdge); // 再将下一个点发散出来的所有边，也加进小根堆中
                        }
                    }
                }
            }
        }

        return resultSet;
    }
}
