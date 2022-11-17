package com.chenjjia.算法.LeetCode;

import java.util.*;

/**
 * Author：  chenjunjia
 * Date：    2022/11/17 2:22
 * WeChat：  China_JoJo_
 * Blog：    https://juejin.cn/user/1856417285289304/posts
 * Github：  https://github.com/chenjjiaa
 */
public class A131_分割回文串 {
    public static void main(String[] args) {

    }

    List<List<String>> ans = new ArrayList<>();
    List<String> path = new ArrayList<>();
    public List<List<String>> partition(String s) {
        if (s == null || s.length() == 0) {
            return ans;
        }
        backtracking(s, 0);
        return ans;
    }

    /**
     startIndex 和 i 就是切割字符串的地方
     状态重置就是选择不同切割方案的过程
     比如：a/b/c/ ---> ab/c/ ---> abc/
     这里演示了 i 从 1 到 3（末尾）的切割位置
     */
    public void backtracking(String s, int startIndex) {
        if (startIndex == s.length()) {
            ans.add(new ArrayList<>(path));
        }
        for (int i = startIndex; i < s.length(); i++) {
            // 判断回文在循环内操作，相当于剪枝
            String cur = s.substring(startIndex, i+1);
            if (isPalindrome(cur)) {
                path.add(cur);
                backtracking(s, i+1);
                path.remove(path.size()-1);
            } else continue;
        }
    }

    public boolean isPalindrome(String s) {
        int left = 0, right = s.length()-1;
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
