package com.chenjjia.算法.LeetCode;

/**
 * Author：  chenjunjia
 * Date：    2022/11/17 19:41
 * WeChat：  China_JoJo_
 * Blog：    https://juejin.cn/user/1856417285289304/posts
 * Github：  https://github.com/chenjjiaa
 */
public class A14_最长公共前缀 {
    /**
     ACM佬说还可以用前缀树处理，ACM佬无敌
     但我选择暴力 2022年11月17日19:39:42
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return null;

        for (int i = 0; i < strs[0].length(); i++) {
            // 先拿出数组中第一个字符串的第一个字符
            char c = strs[0].charAt(i);

            // 拿着这个字符，一个个和数组中的字符串的元素比较
            for (int j = 0; j < strs.length; j++) { // 竖向切换字符串
                if (i == strs[j].length() || c != strs[j].charAt(i)) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }
}
