package com.chenjjia.算法.LeetCode;

/**
 * Author：  chenjunjia
 * Date：    2022/10/23 14:47
 * WeChat：  China_JoJo_
 * Blog：    https://juejin.cn/user/1856417285289304/posts
 * Github：  https://github.com/chenjjiaa
 *
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * P28 1小时28分40秒（中等）
 * LeetCode 3. 无重复字符的最长子串
 * tag：哈希表、字符串、滑动窗口
 */

/**
 * 时间复杂度为O(1) 的滑动窗口比较难理解
 * 使用hashSet去重的双重循环就不难理解，但时间复杂度为O(n²)
 */

import java.util.HashSet;
import java.util.Set;

/**
 * 看到子串和子数组的问题，就要先想到【每个位置结尾怎么怎么样】
 * 以此题为例，那就是：以 i 结尾的情况下，【最长的无重复子串长度】是多少
 */
public class A03_无重复字符的最长子串 {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring2("ppppwwwwkavc000"));
    }

    // 便于理解的滑动窗口模型
    public static int lengthOfLongestSubstring(String s) {
        int res = 0;
        Set<Character> set = new HashSet<>(); // 使用Set，内存占用就多一些
        char[] chars = s.toCharArray();
        int left = 0; // 窗口左边界
        int right = 0; // 窗口右边界

        while (right < s.length()) {
            if (!set.contains(chars[right])) { // 若set中不存在此字符，则添加进去
                set.add(chars[right]);
                right++;
            } else { // 若存在该字符，则将左边界向右移（缩小），将窗口缩小
                set.remove(chars[left]);
                left++;
            }
            res = Math.max(set.size(), res); // 更新最大值的操作，要放在外面
        }
        return res;
    }

    /**
     * 左神解法
     * 这个解法比较取巧，是利用了字符串中字符ASCII码和数组下标的对应关系
     * 然后数组中存放的是：此字符在字符串中最后出现的那一个下标
     */
    public static int lengthOfLongestSubstring2(String s) {
        char[] chars = s.toCharArray();
        int[] map = new int[256]; // 利用 ASCII 和数字的对应关系确定下标索引
        int left = 0; // 窗口左边界
        int right = 0; // 窗口右边界
        int windowSize = -1; // 当前窗口大小
        int maxResult = 0; // 返回结果，也是窗口历史最大值

        // 初始化 map
        for (int i = 0; i < map.length; i++) {
            map[i] = -1;
        }
        for (; right < s.length(); right++) {
            // 比较是左边界索引值大，还是某个char字符在map中的索引值大，大的值会使得子串/子数组最小
            // 若String中的字符串还是新的，那么 left 就保持在原地
            left = Math.max(left, map[chars[right]]);
            windowSize = right - left; // 更新一下当前窗口大小
            maxResult = Math.max(maxResult, windowSize);
            map[chars[right]] = right; // 字符对应的 ASCII 的下标，值是此字符出现的，在字符串最后出现的那次索引
        }
        return maxResult;
    }
}
