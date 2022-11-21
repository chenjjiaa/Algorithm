package com.chenjjia.算法.LeetCode;

import com.chenjjia.算法.LeetCode.structure.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Author：  chenjunjia
 * Date：    2022/11/17 20:14
 * WeChat：  China_JoJo_
 * Blog：    https://juejin.cn/user/1856417285289304/posts
 * Github：  https://github.com/chenjjiaa
 *
 * LeetCode：https://leetcode.cn/problems/merge-k-sorted-lists/
 * 难度：hard
 */
public class A23_合并K个升序链表 {

    /**
     这题在 hard 中，确实不难
     只要知道用优先级队列！

     非升序的链表可能要从新考虑一下

     */
    public ListNode mergeKLists(ListNode[] nodes) {
        if (nodes == null || nodes.length == 0) {
            return null;
        }
        ListNode resNode = new ListNode(0);
        ListNode cur = resNode; // cur 是斥候，去帮 resNode 打造接下来的链子

        // 优先级队列，本题的重中之重！
        PriorityQueue<ListNode> queue = new PriorityQueue(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        for (ListNode node : nodes) {
            if (node == null) { // 这里题目可能会给一个集合中的一个空节点
                continue;
            }
            queue.add(node);
        }
        while (!queue.isEmpty()) {
            ListNode poll = queue.poll();
            cur.next = poll;
            cur = cur.next;
            if (poll.next != null) { // 如果当前节点还有 next，就继续添加进队列！！！
                queue.add(poll.next);
            }
        }
        // 会了上面那两步重要的步骤：使用优先级队列、从新将node的next添加进queue中
        // 那本题就没什么难点了
        return resNode.next;
    }
}
