package com.chenjjia.算法.LeetCode;

import com.chenjjia.算法.链表.反转链表;

/**
 * Author：  chenjunjia
 * Date：    2022/11/12 16:14
 * WeChat：  China_JoJo_
 * Blog：    https://juejin.cn/user/1856417285289304/posts
 * Github：  https://github.com/chenjjiaa
 *
 * tag：链表、双指针
 *
 * LeetCode：https://leetcode.cn/problems/remove-nth-node-from-end-of-list/?favorite=2cktkvj
 */
public class A19_删除链表的倒数第N个结点 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
//        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);

        printLinkList(removeNthFromEnd(head, 1));
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return head;
        }
        if (head.next == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        // 让快指针先走 N 步
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        // 特殊情况：移除首节点
        if (fast == null) { // 因为首节点的位置，就是倒数第 List.size() 个，所以快指针会空
            head = head.next;
        }
        while (fast != null && fast.next != null) { // 快慢指针一起走
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }

    public static void printLinkList(ListNode head) {
        System.out.print("LinkList : ");
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) {
                System.out.print(" -> ");
            }
            head = head.next;
        }
        if (head == null) {
            System.out.println("null");
        }
        System.out.println();
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {
        }
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
