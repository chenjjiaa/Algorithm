package com.chenjjia.算法.图;

import com.chenjjia.算法.图.结构.Edge;
import com.chenjjia.算法.图.结构.Graph;
import com.chenjjia.算法.图.结构.Node;

/**
 * Author：  chenjunjia
 * Date：    2022/8/4 10:52
 * WeChat：  China_JoJo_
 *
 * 图的适配器
 */
public class GraphGenerator {

    public static void main(String[] args) {
        // 二维数组
        int[][] matrix = {
                {1, 2, 3},
                {1, 2, 3},
                {1, 2, 3},
                {1, 2, 3},
                {1, 2, 3},
                {1, 2, 3}
        };
        System.out.println(matrix.length);
    }

    /**
     * 接口函数
     * @return 返回自己自定义的图
     */
    public static Graph createGraph(Integer[][] matrix) {
        Graph graph = new Graph();
        // 从数组接收值
        for (int i = 0; i < matrix.length; i++) {
            // 取数值，每种数据结构都不同，取数值看情况来
            Integer weight = matrix[i][0];
            Integer from = matrix[i][1];
            Integer to = matrix[i][2];
            // 接下来是泛用性强的步骤了
            // 若图中无该点
            if (!graph.nodes.containsKey(from)) {
                graph.nodes.put(from, new Node(from));
            }
            if (!graph.nodes.containsKey(to)) {
                graph.nodes.put(to, new Node(to));
            }
            // 创建点
            Node fromNode = graph.nodes.get(from);
            Node toNode = graph.nodes.get(to);
            // 创建边
            Edge edge = new Edge(weight,fromNode,toNode);
            // 设置点集中点的属性
            toNode.in++;
            fromNode.out++;
            fromNode.nexts.add(toNode);
            fromNode.edges.add(edge);
            graph.edges.add(edge);
        }
        return graph;
    }
}
