package com.chenjjia.算法.图;

import com.chenjjia.算法.图.结构.Edge;
import com.chenjjia.算法.图.结构.EdgeComparator;
import com.chenjjia.算法.图.结构.Graph;
import com.chenjjia.算法.图.结构.Node;

import java.util.*;

/**
 * Author：  chenjunjia
 * Date：    2022/8/5 9:23
 * WeChat：  China_JoJo_
 *
 * Kruskal算法是最小生成树算法：保证整个图的连通性，但所有边的权值加起来最小
 * Kruskal算法针对无向图
 */
public class Kruskal {

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


//        for (Edge edge : kruskalMST(graph)) {
//            System.out.println(edge.weight);
//        }

//        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(new EdgeComparator());
//        priorityQueue.add(edge1);
//        priorityQueue.add(edge2);
//        priorityQueue.add(edge3);
//        priorityQueue.add(edge4);
//
//        System.out.println(priorityQueue.poll().weight);
//        System.out.println(priorityQueue.poll().weight);
//        System.out.println(priorityQueue.poll().weight);
//        System.out.println(priorityQueue.poll().weight);

//        System.out.println(graph.nodes.values());
//        for (Node node : graph.nodes.values()) {
//            System.out.println(node.value);
//        }
    }

    /**
     * Kruskal算法最小生成树
     * 这个没使用并查集（但思想是一样的）
     * MST：Minimum Spanning Tree 最小生成树
     * @return 最下生成树的边的集合
     */
    public static Set<Edge> kruskalMST(Graph graph) {
        Set<Edge> resultSet = new HashSet<>();
        Collection<Node> values = graph.nodes.values();
        ArrayList<Node> arrayList = new ArrayList(values);
        MySets mySets = new MySets(arrayList);
        Edge[] edges = new Edge[graph.edges.size()];
        int arrIndex = 0;
        // 将图的边添加进数组
        for (Edge edge : graph.edges) {
            edges[arrIndex++] = edge;
        }
        // 给边的权值排序
        Arrays.sort(edges,new EdgeComparator());
        ArrayList<Node> edgeArrayList = new ArrayList<>();
        for (int i = 0; i < edges.length; i++) {
            if (!mySets.isSameSet(edges[i].from, edges[i].to)) {
                /**
                 * 合并
                 * 踩坑点2 ，merge 方法要修改
                 */
                mySets.merge(edges[i].from, edges[i].to, edgeArrayList);
                resultSet.add(edges[i]);
            }
        }
        return resultSet;
    }

    // TODO 并查集的方法（在进阶教程）并查集会快很多，时间复杂度常数级

    public static class MySets {
        /**
         * key：节点
         * value：节点所在的并查集中
         */
        HashMap<Node, List<Node>> setMap;

        public MySets(List<Node> nodes) {
            setMap = new HashMap<>();
            /**
             * 初始化的时候是将图的所有节点初始化成一个个并查集
             * 并查集中只包含单个节点
             */
            for (Node node : nodes) {
                List<Node> nodeArrayList = new ArrayList<>();
                nodeArrayList.add(node);
                setMap.put(node, nodeArrayList);
            }
        }

        /**
         * 查看两点在不在同一个集合中
         * 在同一个集合才会形成环
         * @return 在同一个并查集中返回 TRUE，不同则返回 FALSE
         */
        public boolean isSameSet(Node from, Node to) {
            List<Node> fromList = setMap.get(from);
            List<Node> toList = setMap.get(to);
            return fromList == toList;
        }

        /**
         * 若两点不在集合中，将 from 和 to 节点合并在同一个集合
         * 注：这个不是并查集方法，这个没有并查集快
         */
        /**
         * bug：后续元素指向集合不一样了
         * 解决方案，传入一个额外的 mergeList 统一指向
         */
        public void merge(Node from, Node to, List<Node> mergeList) {
            List<Node> fromList = setMap.get(from);
            List<Node> toList = setMap.get(to);

            if (fromList != mergeList && toList != mergeList) {
                for (Node node : fromList) {
                    mergeList.add(node);
                    setMap.put(node, mergeList);
                }
                for (Node node : toList) {
                    mergeList.add(node);
                    setMap.put(node, mergeList);
                }
            } else if (fromList != mergeList) { // 若 fromList 不是 mergeList 则将 fromList 拷贝到 mergeList 中
                for (Node node : fromList) {
                    mergeList.add(node);
                    setMap.put(node, mergeList);
                }
            } else { // 若 toList 不是 mergeList 则将 toList 拷贝到 mergeList 中
                for (Node node : toList) {
                    mergeList.add(node);
                    setMap.put(node, mergeList);
                }
            }
            // 将 to 的节点添加到 from
//            for (Node node : toList) {
//                fromList.add(node);
//                // 将 to 的集合与 from 的合并，原先的舍去了
//                setMap.put(to,fromList);
//            }
        }
    }
}
