package com.chenjjia.算法.LeetCode;

import java.util.*;

/**
 * Author：  chenjunjia
 * Date：    2022/11/14 21:27
 * WeChat：  China_JoJo_
 * Blog：    https://juejin.cn/user/1856417285289304/posts
 * Github：  https://github.com/chenjjiaa
 */
public class A26_删除有序数组中的重复项 {
    public static void main(String[] args) {
        Deque deque = removeDuplicates2(new int[]{1, 1, 1});
        printArray(deque);
    }

    public static int removeDuplicates1(int[] nums) {
        if (nums.length < 2) {
            return nums[0];
        }
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (fast-1 >= 0 && nums[fast] == nums[fast-1]) {
                continue;
            }
            nums[slow++] = nums[fast];
        }
        return slow;
    }

    // 消除相邻的重复元素还可以用栈
    public static Deque removeDuplicates2(int[] nums) {
        if (nums.length < 2) {
            ArrayDeque arrayDeque = new ArrayDeque();
            arrayDeque.add(nums[0]);
            return arrayDeque;
        }
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            if (!stack.isEmpty() && stack.peekFirst() == nums[i]) {
                // stack.pollFirst();
            } else {
                stack.addFirst(nums[i]);
            }
        }
        return stack;
    }

    public static void printArray(Deque stack) {
        while (!stack.isEmpty()) {
            System.out.print(stack.pollFirst() + " ");
        }
    }
}
