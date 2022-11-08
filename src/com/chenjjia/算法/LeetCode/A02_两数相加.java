package com.chenjjia.算法.LeetCode;

/**
 * Author：  chenjunjia
 * Date：    2022/11/8 20:52
 * WeChat：  China_JoJo_
 * Blog：    https://juejin.cn/user/1856417285289304/posts
 * Github：  https://github.com/chenjjiaa
 *
 * LeetCode 2.两数相加
 * 链表题、可递归解
 */
public class A02_两数相加 {
    public static void main(String[] args) {
        Node l1 = new Node(5);
        Node l2 = new Node(6);
        l1.next = new Node(9);
        l1.next.next = new Node(8);
        l2.next = new Node(1);
        l2.next.next = new Node(9);

        printLinkList(addTwoNumbers(l1, l2));
    }

    public static Node addTwoNumbers(Node l1, Node l2) {
        Node res = new Node(0);
        Node cur = res;
        int carry = 0; // 进位信息

        // 任意一个链表不为空、进位不为0，满足其一，就可以循环
        while (l1 != null || l2 != null || carry != 0) {
            int val1 = l1 == null ? 0 : l1.data;
            int val2 = l2 == null ? 0 : l2.data;
            int sum = val1 + val2 + carry;
//            carry = (val1 + val2) / 10; // 计算进位信息，最多能到 1，不可能到 2
            carry = sum / 10; // 计算进位信息，最多能到 1，不可能到 2

            res.next = new Node(sum % 10);
            res = res.next;

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        return cur.next;
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
