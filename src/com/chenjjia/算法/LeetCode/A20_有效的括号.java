package com.chenjjia.算法.LeetCode;

import java.util.Stack;

/**
 * Author：  chenjunjia
 * Date：    2022/11/11 9:46
 * WeChat：  China_JoJo_
 * Blog：    https://juejin.cn/user/1856417285289304/posts
 * Github：  https://github.com/chenjjiaa
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号。
 *
 * 示例 1：
 * 输入：s = "()"
 * 输出：true
 *
 * 示例 2：
 * 输入：s = "()[]{}"
 * 输出：true
 *
 * 示例 3：
 * 输入：s = "(]"
 * 输出：false
 *
 * LeetCode：https://leetcode.cn/problems/valid-parentheses/?favorite=2cktkvj
 * 难度：简单
 * tag：栈
 */
public class A20_有效的括号 {
    public static void main(String[] args) {
        System.out.println(isValid("{}(){}[][]{}()"));
    }

    /**
     * 字符串只包含 “(”，“)”，“[”，“]”，"{"，"}"
     */
    public static boolean isValid(String s) {
        if (s == null || s.isEmpty() || (s.length() & 1) == 1) {
            return false;
        }
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                stack.push(')');
            } else if (chars[i] == '[') {
                stack.push(']');
            } else if (chars[i] == '{') {
                stack.push('}');
            } else if (stack.isEmpty() || stack.pop() != chars[i]) { // 当遍历到的元素不是左半括号，则需要与右半进行匹配
                return false;
            }
        }
        return stack.isEmpty();
    }
}
