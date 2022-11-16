package com.chenjjia.算法.LeetCode;

import java.util.*;

/**
 * Author：  chenjunjia
 * Date：    2022/11/16 11:20
 * WeChat：  China_JoJo_
 * Blog：    https://juejin.cn/user/1856417285289304/posts
 * Github：  https://github.com/chenjjiaa
 */
public class A260_只出现一次的数字III {
    public static void main(String[] args) {
    }

    public void backtracking(int n, int k, int start, LinkedList<Integer> queue, List<List<Integer>> ans) {
        if (k == queue.size()) { // 后续数字不足那就直接返回，或者收集满了也返回
            ans.add(queue);
            return;
        }
        if (start - k + 1 < k)
            return;
        for (; start < n; start++) {
            queue.addFirst(start);
            backtracking(n, k, start, queue, ans);
            // 回溯操作
            queue.pollLast();
        }
    }

    /**
     * 1、将所有数进行异或
     * 2、得到两个目标数的异或值 ：a ^ b
     * 3、提出 a ^ b 的最右侧 1
     * 4、用这一位的 "1" 重新遍历异或数组，结果会分为这一位是0的和这一位是1的
     * 5、这一位是0的统一异或一遍。这一位是1的也统一异或一边，然后利用自反性将偶数的消除
     *    注意这一位是1不代表整个数是1，if应该用(xxx != 0) 判断
     *
     * 注：提取最右侧1：原码 & 补码
     */
    public int[] singleNumber(int[] nums) {
        int eor = 0, num1 = 0, num2 = 0;
        for (int num : nums) {
            eor ^= num;
        }
        int rightOne = eor & (~eor + 1);
        for (int num : nums) {
            if ((num & rightOne) != 0) { // 注意这里的判断应该是 != 0，
                num1 ^= num;
            } else {
                num2 ^= num;
            }
        }
        return new int[] {num1, num2};
    }
}
