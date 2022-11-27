package com.chenjjia.算法.LeetCode;

import com.chenjjia.算法.LeetCode.structure.ListNode;

import java.util.Stack;

/**
 * Author：  chenjunjia
 * Date：    2022/11/18 15:19
 * WeChat：  China_JoJo_
 * Blog：    https://juejin.cn/user/1856417285289304/posts
 * Github：  https://github.com/chenjjiaa
 *
 * LeetCode：https://leetcode.cn/problems/palindrome-linked-list/comments/
 */
public class A234_回文链表 {
    // 空间复杂度使用 n/2 的栈
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode fast = head;
        ListNode slow = head;
        Stack<ListNode> stack = new Stack<>();
        while (fast != null && fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        while (slow != null) {
            if (slow.next != null)
                stack.push(slow.next);
            slow = slow.next;
        }
        while (!stack.isEmpty()) {
            if (head.val != stack.pop().val) {
                return false;
            }
            head = head.next;
        }
        return true;
    }
}
