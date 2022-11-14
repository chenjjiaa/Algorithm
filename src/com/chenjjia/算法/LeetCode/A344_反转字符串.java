package com.chenjjia.算法.LeetCode;

import java.util.Stack;

/**
 * Author：  chenjunjia
 * Date：    2022/11/13 21:25
 * WeChat：  China_JoJo_
 * Blog：    https://juejin.cn/user/1856417285289304/posts
 * Github：  https://github.com/chenjjiaa
 */
public class A344_反转字符串 {
    public static void main(String[] args) {

    }

    // 很经典的双指针
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length-1;
        while(left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            ++left;
            --right;
        }
    }
}
