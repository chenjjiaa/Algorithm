package com.chenjjia.算法.LeetCode;

import java.util.*;

/**
 * Author：  chenjunjia
 * Date：    2022/11/19 20:45
 * WeChat：  China_JoJo_
 * Blog：    https://juejin.cn/user/1856417285289304/posts
 * Github：  https://github.com/chenjjiaa
 *
 * 相似题：215 数组中的第K个最大元素（很像，只不过是多了一个 HashMap 对元素的处理而已）
 * LeetCode：https://leetcode.cn/problems/top-k-frequent-elements/
 */
public class A347_前K个高频元素 {

    public static void main(String[] args) {
        // 创建一个 HashMap
        HashMap<Integer, String> sites = new HashMap<>();

        // 往 HashMap 添加一些元素
        sites.put(1, "Google");
        sites.put(2, "Runoob");
        sites.put(3, "Taobao");
        System.out.println("sites HashMap: " + sites);

        // key 的映射存在于 HashMap 中
        // Not Found - 如果 HashMap 中没有该 key，则返回默认值
        String value1 = sites.getOrDefault(1, "Not Found");
        System.out.println("Value for key 1:  " + value1);

        // key 的映射不存在于 HashMap 中
        // Not Found - 如果 HashMap 中没有该 key，则返回默认值
        String value2 = sites.getOrDefault(4, "Not Found");
        System.out.println("Value for key 4: " + value2);
    }

    /**
     * 小根堆
     */
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>((o1, o2) -> o1.getValue() - o2.getValue());
        HashMap<Integer, Integer> map = new HashMap<>(); // key保存的是数组中的元素，value：这个元素出现的次数
        int[] ans = new int[k];
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            heap.add(entry);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        for (int i = 0; i < ans.length; i++) {
            ans[i] = heap.poll().getKey();
        }
        return ans;
    }
}
