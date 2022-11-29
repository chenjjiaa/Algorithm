package com.chenjjia.算法.LeetCode;

import com.chenjjia.算法.LeetCode.structure.ListNode;

/**
 * Author：  chenjunjia
 * Date：    2022/11/19 1:14
 * WeChat：  China_JoJo_
 * Blog：    https://juejin.cn/user/1856417285289304/posts
 * Github：  https://github.com/chenjjiaa
 *
 * LeetCode：https://leetcode.cn/problems/reverse-nodes-in-k-group/?company_slug=bytedance
 */
public class A25_K个一组翻转链表 {

    /**
     * 本题分为两个步骤：
     * 1、反转链表（基础）
     * 2、分组反转链表
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        ListNode start = head;
        ListNode end = head;
        ListNode next;
        ListNode pre = dummy;
        dummy.next = head;

        while (true) {
            // 先移动 end 指针
            for (int i = 1; i < k && end != null; i++) {
                end = end.next;
            }
            // 若不足 k 个，则退出循环
            if (end == null) break;

            // 开始分组反转，并拼接链表
            next = end.next;
            end.next = null;
            end = start; // 刚刚开始的 end 往后移 是因为要用来保存反转前的 next，而此时是赋值给反转后的 end
            start = reverse(start); // 反转后的 start

            // 开始拼接反转后的链表
            end.next = next;
            pre.next = start; // 这么做的目的是将 pre 指向的节点 引向 start
            pre = end; // 然后 pre 跑到新的位置，也就是即将排序部分的前一个位置，即当前 end 位
            start = next; // 来到即将排序链表的第一个节点位
            end = next; // 来到即将排序链表的第一个节点位
            // 初始化 end 和 start 都是在同一起跑线的，然后 end 去找后面 k 个位置
        }
        return dummy.next;
    }

    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode cur = head;
        ListNode pre = null;
        ListNode next;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
