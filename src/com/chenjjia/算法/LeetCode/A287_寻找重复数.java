package com.chenjjia.算法.LeetCode;

/**
 * Author：  chenjunjia
 * Date：    2022/11/15 1:26
 * WeChat：  China_JoJo_
 * Blog：    https://juejin.cn/user/1856417285289304/posts
 * Github：  https://github.com/chenjjiaa
 *
 * LeetCode：https://leetcode.cn/problems/find-the-duplicate-number/
 * 还有这题也是一样的：https://leetcode.cn/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/
 *
 * 这题很有意思啊，这题就是 “百囚徒问题” 的演变
 */
public class A287_寻找重复数 {
    public static void main(String[] args) {

    }

    public static int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        /**
         * 在这种特殊的数据状况下：1 ~ n 且有一个重复（看做入环节点）
         * 数组的 value 值可以看做是下一个地方的 next 指针
         * nums[i] 存放的是下个节点的索引，也就相当于是 nextNode
         */
        do {
            slow = nums[slow]; // 慢指针走一步，相当于是 slow = slow.next
            fast = nums[nums[fast]]; // 快指针走两步，相当于 fast = nums[fast.next] => fast.next.next
        } while (slow != fast);
        // 相遇的时候，快指针归零，然后快指针和慢指针 一次走一步，和慢指针相遇就是入环节点
        fast = 0;
        while (slow != fast) {
            fast = nums[fast];
            slow = nums[slow];
        }
        return slow;
    }
}
