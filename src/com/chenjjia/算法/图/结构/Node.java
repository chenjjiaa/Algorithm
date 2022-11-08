package com.chenjjia.算法.图.结构;

import java.util.ArrayList;

/**
 * Author：  chenjunjia
 * Date：    2022/8/3 17:41
 * WeChat：  China_JoJo_
 */
public class Node {

    /**
     * 点的编号，也可能是字符串
     */
    public int value;

    /**
     * 入度：有多少个点指向自己
     * 无向图的入度出度都是一样的
     */
    public int in;

    /**
     * 出度：自己指向多少个点
     */
    public int out;

    /**
     * 从自己出发，相邻的点（指出去的点）
     */
    public ArrayList<Node> nexts;

    /**
     * 自己所拥有的边（指出去的边）
     */
    public ArrayList<Edge> edges;

    public Node(int value) {
        this.value = value;
        this.in = 0;
        this.out = 0;
        this.nexts = new ArrayList<>();
        this.edges = new ArrayList<>();
    }
}
