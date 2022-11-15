package com.chenjjia.算法.LeetCode;

/**
 * Author：  chenjunjia
 * Date：    2022/11/15 12:27
 * WeChat：  China_JoJo_
 * Blog：    https://juejin.cn/user/1856417285289304/posts
 * Github：  https://github.com/chenjjiaa
 */
public class A05_最长回文子串 {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("tattarrattat"));
    }

    public static String longestPalindrome(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) { // 每个位置都扩散
            // 假设回文串是奇数时  扩散，左边界和右边界都是i
            String s1 = spread(s, i, i);
            // 假设回文串是偶数时  扩散
            String s2 = spread(s, i, i+1);
            String longer = (s1.length() > s2.length() ? s1 : s2);
            res = res.length() > longer.length() ? res : longer;
        }
        return res;
    }

    public static String spread(String s, int left, int right) {
        // 若左右边界都不越界，且左右扩散出去时，字符相等
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left+1, right);
    }
}
