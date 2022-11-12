package com.chenjjia.算法.LeetCode;

/**
 * Author：  chenjunjia
 * Date：    2022/11/12 1:07
 * WeChat：  China_JoJo_
 * Blog：    https://juejin.cn/user/1856417285289304/posts
 * Github：  https://github.com/chenjjiaa
 *
 * 给你两个单链表的头节点 headA 和 headB
 * 请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
 *
 * LeetCode：https://leetcode.cn/problems/intersection-of-two-linked-lists/
 */
public class A160_相交链表 {
    public static void main(String[] args) {

    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode c1 = headA;
        ListNode c2 = headB;
        int l1 = 0;
        int l2 = 0;
        while (c1 != null) {
            c1 = c1.next;
            l1++;
        }
        while (c2 != null) {
            c2 = c2.next;
            l2++;
        }
        c1 = l1 - l2 > 0 ? headA : headB; // 将长链表赋值给 c1
        c2 = c1 == headA ? headB : headA;
        // c1 先走差值步，再一起走
        for (int i = 0; i < Math.abs(l1 - l2); i++) {
            c1 = c1.next;
        }
        while (c1 != c2) {
            c1 = c1.next;
            c2 = c2.next;
        }
        return c1 == c2 ? c1 : null;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

}


