package com.chenjjia.算法.LeetCode;

/**
 * Author：  chenjunjia
 * Date：    2022/11/15 19:41
 * WeChat：  China_JoJo_
 * Blog：    https://juejin.cn/user/1856417285289304/posts
 * Github：  https://github.com/chenjjiaa
 *
 * 给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。
 * 1）如果剩余字符少于 k 个，则将剩余字符全部反转。
 * 2）如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 *  
 * 示例 1：
 * 输入：s = "abcdefg", k = 2
 * 输出："bacdfeg"
 *
 * 示例 2：
 * 输入：s = "abcd", k = 2
 * 输出："bacd"
 *
 * 链接：https://leetcode.cn/problems/reverse-string-ii
 */

/**
 * 本题的难点就是，2k的跳，还有就是结尾的处理
 * 延伸：3k的跳，然后反转前k
 */
public class A541_反转字符串II {
    public static void main(String[] args) {

    }

    /**
     三种情况：
     1、可以跳2k，则将前k翻转
     2、剩余部分大于k，小于2k，则将前k翻转
     3、不够k，将剩余的所有翻转
     */
    public static String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i += 2*k) {
            int end = Math.min(chars.length, i+k); // 巧妙的确定了翻转结尾的下标
            reverse(chars, i, end);
        }
        return new String(chars);
    }

    public static void reverse(char[] chars, int i, int j) {
        while (i < j) {
            char temp = chars[i];
            chars[i++] = chars[j];
            chars[j++] = temp;
        }
    }
}
