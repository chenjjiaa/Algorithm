package com.chenjjia.算法.链表;

/**
 * Author：  chenjunjia
 * Date：    2022/7/28 9:49
 * WeChat：  China_JoJo_
 */
public class 反转链表 {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        printLinkList(head);
        printLinkList(reverseList(head));
    }

    // cur 转向，pre 移动，cur 移动，next 移动
    public static Node reverseList(Node cur) {
        if (cur == null || cur.next == null) {
            return cur;
        }
        Node pre = null;
        Node next = cur.next; // 提前保存下一个节点
        while (cur != null) {
            cur.next = pre;
            pre = cur;
            cur = next;
            next = next == null ? null : next.next;
            //=== 循环结束，cur、next 均为 null ===
        }
        return pre;
    }

    public static void printLinkList(Node head) {
        System.out.print("LinkList : ");
        while (head != null) {
            System.out.print(head.data);
            if (head.next != null) {
                System.out.print(" -> ");
            }
            head = head.next;
        }
        System.out.println();
    }

    public static class Node {
        private int data;
        private Node next;
        public Node(int data) {
            this.data = data;
        }
    }
}
