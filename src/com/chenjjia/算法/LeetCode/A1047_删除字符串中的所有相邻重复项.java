package com.chenjjia.算法.LeetCode;

import java.util.Stack;

/**
 * Author：  chenjunjia
 * Date：    2022/11/11 0:34
 * WeChat：  China_JoJo_
 * Blog：    https://juejin.cn/user/1856417285289304/posts
 * Github：  https://github.com/chenjjiaa
 *
 * LeetCode：https://leetcode.cn/problems/remove-all-adjacent-duplicates-in-string/
 * tag：栈、字符串
 */
public class A1047_删除字符串中的所有相邻重复项 {
    public static void main(String[] args) {
        System.out.println(removeDuplicates("abbaca"));
//        System.out.println("123".charAt(0));
    }

    public static String removeDuplicates(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            if (stack.isEmpty()) { // 若栈空直接拼放入即可
                stack.push(chars[i]);
            } else if (chars[i] != stack.peek()) { // 若栈顶元素和此元素不一样，也放入
                stack.push(chars[i]);
            } else { // 栈顶元素和char[i]一样，则弹栈（消除）然后 i++ 到下一跳
                stack.pop();
            }
        }
        String result = "";
        while (!stack.isEmpty()) { // 将栈的元素正序拼接回原本字符
            result = stack.pop() + result;
        }
        return result;
    }
}
