package com.chenjjia.算法.LeetCode;

/**
 * Author：  chenjunjia
 * Date：    2022/11/11 10:15
 * WeChat：  China_JoJo_
 * Blog：    https://juejin.cn/user/1856417285289304/posts
 * Github：  https://github.com/chenjjiaa
 *
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * LeetCode：https://leetcode.cn/problems/merge-two-sorted-lists/?favorite=2cktkvj
 * 难度：简单
 * tag：递归、链表
 */
public class A21_合并两个有序链表 {
    public static void main(String[] args) {
//        System.out.println(mergeTwoLists());
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return null;
        }
        if (list1 == null || list2 == null) {
            return list1 == null ? list2 : list1;
        }
        ListNode ans = new ListNode(0);
        ListNode cur = ans;  // 返回值链表的当前指针
        ListNode c1 = list1; // 当前节点的指针
        ListNode c2 = list2;
        while (c1 != null && c2 != null) {
            if (c1.val < c2.val) { // 谁小连谁
                cur.next = c1;
                c1 = c1.next;
            } else {
                cur.next = c2;
                c2 = c2.next;
            }
            cur = cur.next;
        }
        if (c1 != null) { // 链接剩余部分
            cur.next = c1;
        }
        if (c2 != null) { // 链接剩余部分
            cur.next = c2;
        }
        return ans.next;
    }
}

class ListNode {
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