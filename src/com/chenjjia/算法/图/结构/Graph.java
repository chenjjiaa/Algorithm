package com.chenjjia.算法.图.结构;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Author：  chenjunjia
 * Date：    2022/8/3 17:38
 * WeChat：  China_JoJo_
 *
 * 图包含 点集、边集
 *
 * 这是属于自己构造的一种有关图的数据结构，
 * 可以将特殊的数据结构转换成这个图，自己另外写一个适配器即可
 * 然后转化成自己熟悉的数据结构就可以解题了
 * 只需要用这种数据结构实现所有算法即可，其它数据结构转化成这个数据结构就行
 */
public class Graph {
    /**
     * 点集
     * 包括点的编号和具体的点
     * 编号可能是 int，也可能是 String
     */
    public HashMap<Integer,Node> nodes;

    /**
     * 边集
     */
    public HashSet<Edge> edges;

    public Graph() {
        nodes = new HashMap<>();
        edges = new HashSet<>();
    }
}
