package com.chenjjia.算法.LeetCode;

import com.chenjjia.算法.LeetCode.structure.ListNode;

/**
 * Author：  chenjunjia
 * Date：    2022/11/16 1:19
 * WeChat：  China_JoJo_
 * Blog：    https://juejin.cn/user/1856417285289304/posts
 * Github：  https://github.com/chenjjiaa
 */
public class A141_环形链表 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        System.out.println(hasCycle(head));
    }

    public static boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        do {
            if (fast == null || fast.next == null || fast.next.next == null)
                return false;
            fast = fast.next.next;
            slow = slow.next;
        } while (fast != slow);
        return fast == slow;
    }
}
