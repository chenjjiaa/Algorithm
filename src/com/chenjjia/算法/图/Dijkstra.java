package com.chenjjia.算法.图;

import com.chenjjia.算法.图.结构.Edge;
import com.chenjjia.算法.图.结构.Graph;
import com.chenjjia.算法.图.结构.Node;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Author：  chenjunjia
 * Date：    2022/8/8 10:03
 * WeChat：  China_JoJo_
 *
 * 单源最短路径：Dijkstra算法是最短路径算法，是两点之间的关系
 * 适用范围：整张图不能有权值累加和为负数的环，如果有，每转一圈都会变得更小，就会不断更新不断循环，直至系统最小值
 */
public class Dijkstra {
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

        Map<Node, Integer> nodeIntegerMap = dijkstra1(node1);
        for (Integer integer : nodeIntegerMap.values()) {
            System.out.println(integer);
        }
    }

    /**
     * 此方法不能有负数的边
     * @param node 任意一个节点
     * @return 输入的节点到的其他所有节点的最短距离
     */
    public static Map<Node,Integer> dijkstra1(Node node) {
        /**
         * Key：每个节点
         * Value：源节点到此节点所需的距离
         */
        HashMap<Node, Integer> distanceMap = new HashMap<>();
        HashSet<Node> selectedNodes = new HashSet<>(); // 已锁定的节点，以后不再碰
        distanceMap.put(node,0);
//        Node minNode = getMinDistanceAndUnselectedNode(distanceMap, selectedNodes);
        Node minNode = node; // 一开始就是 node
        while (minNode != null) {
            int distance = distanceMap.get(minNode);
            for (Edge edge : minNode.edges) { // 解锁该点能到达的地方
                Node toNode = edge.to;
                if (!distanceMap.containsKey(toNode)) { // 若该点不在 distancMap 中，则是新的点，添加到 distancMap 中
                    distanceMap.put(toNode, distance + edge.weight);
                }
                else {
                    distanceMap.put(toNode, Math.min(distance + edge.weight, distanceMap.get(toNode))); // 若遇到该点，则重新比较距离，将较小值放入 distancMap
                }
            }
            selectedNodes.add(minNode);
            minNode = getMinDistanceAndUnselectedNode(distanceMap, selectedNodes);
        }
        return distanceMap;
    }

    /**
     * 在 distancMap 中找到一个最小的要处理的点，但这个点是没选择过的
     * @param distanceMap distanceMap
     * @param selectedNodes selectedNodes
     * @return 距离最小的一个点
     */
    private static Node getMinDistanceAndUnselectedNode(HashMap<Node, Integer> distanceMap, HashSet<Node> selectedNodes) {
        Node minNode = null;
        Integer minDistance = Integer.MAX_VALUE; // 初始化系统最大
        for (Map.Entry<Node, Integer> entry : distanceMap.entrySet()) {
            Integer minValue = entry.getValue();
            Node node = entry.getKey();
            // 若未锁定，则选出一个最小值节点
            if (!selectedNodes.contains(node) && minValue < minDistance) {
                minNode = node;
                minDistance = minValue;
            }
        }
        return minNode;
    }

    // TODO dijkstra算法优化，涉及到改写堆，也就是堆的内部的向上或者向下调整，在已经给定的数据之后还能做出调整。如果一个数据进到堆里去不需要改他的值了，那么可以用普通堆结构，但 dijkstra算法要动态改变值

}