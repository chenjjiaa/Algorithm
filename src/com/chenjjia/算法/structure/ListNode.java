package com.chenjjia.算法.LeetCode.structure;

import com.chenjjia.算法.LeetCode.A21_合并两个有序链表;

/**
 * Author：  chenjunjia
 * Date：    2022/11/13 17:39
 * WeChat：  China_JoJo_
 * Blog：    https://juejin.cn/user/1856417285289304/posts
 * Github：  https://github.com/chenjjiaa
 */
public class ListNode {
    public int val;
    public ListNode next;

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
