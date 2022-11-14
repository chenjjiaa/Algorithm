package com.chenjjia.算法.LeetCode;

import java.util.Arrays;

/**
 * Author：  chenjunjia
 * Date：    2022/11/14 21:38
 * WeChat：  China_JoJo_
 * Blog：    https://juejin.cn/user/1856417285289304/posts
 * Github：  https://github.com/chenjjiaa
 *
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，
 * 第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 返回容器可以储存的最大水量。
 *
 * 示例：
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 *
 * LeetCode：https://leetcode.cn/problems/container-with-most-water/
 */
public class A11_盛最多水的容器 {
    public static void main(String[] args) {

    }

    public static int maxArea(int[] height) {
        if (height.length < 3) return 0;
        int left = 0;
        int right = height.length-1;
        int res = 0;

        while (left < right) {
            res = Math.max(res, (Math.min(height[left], height[right])* (right-left)));
            /**
             * 不管是左指针向右移动一位，还是右指针向左移动一位，容器的底都是一样的，都比原来减少了1。
             * 这种情况下我们想要让指针移动后的容器面积增大，就要使移动后的容器的高尽量大，
             * 所以我们选择指针所指的高较小的那个指针进行移动，这样我们就保留了容器较高的那条边，
             * 放弃了较小的那条边，以获得有更高的边的机会
             */
            if (height[left] < height[right])
                left++;  // 左边移动还会有更大的可能性
            else
                right--; // 右边移动还会有更大的可能性
        }
        return res;
    }
}
