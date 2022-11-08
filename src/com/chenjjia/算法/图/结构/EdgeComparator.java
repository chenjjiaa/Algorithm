package com.chenjjia.算法.图.结构;

import java.util.Comparator;

/**
 * Author：  chenjunjia
 * Date：    2022/8/5 10:22
 * WeChat：  China_JoJo_
 */
public class EdgeComparator implements Comparator<Edge> {

    /**
     * 从小到大排列
     */
    @Override
    public int compare(Edge o1, Edge o2) {
//        return o1.weight.compareTo(o2.weight);
        return o1.weight - o2.weight;
    }
}
