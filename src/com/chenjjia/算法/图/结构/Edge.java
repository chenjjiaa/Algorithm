package com.chenjjia.算法.图.结构;

/**
 * Author：  chenjunjia
 * Date：    2022/8/3 17:41
 * WeChat：  China_JoJo_
 */

/**
 * 无向图的边相当于两个有向的边拼起来
 */
public class Edge {
    /**
     * 权重
     */
    public Integer weight;

    /**
     * 从哪里来
     */
    public Node from;

    /**
     * 到哪里去
     */
    public Node to;

    public Edge(int weight, Node from, Node to) {
        this.weight = weight;
        this.from = from;
        this.to = to;
    }
}
