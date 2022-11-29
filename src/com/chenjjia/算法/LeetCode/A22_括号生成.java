package com.chenjjia.算法.LeetCode;

import java.util.*;

/**
 * Author：  chenjunjia
 * Date：    2022/11/18 18:02
 * WeChat：  China_JoJo_
 * Blog：    https://juejin.cn/user/1856417285289304/posts
 * Github：  https://github.com/chenjjiaa
 *
 * LeetCode：https://leetcode.cn/problems/generate-parentheses/
 */
public class A22_括号生成 {


    /**
     一般括号序列的问题会用到一些结论：括号合法的充要条件
     1、任意一个前缀位置，'(' 数量 ≥ ')'   左括号数量大于等于右括号数量
     2、这个字符串的左右括号数量要相等

     这个回溯和之前的不同的是，不需要 for 循环
     */
    List<String> ans = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        if (n < 1) {
            return ans;
        }
        StringBuilder builder = new StringBuilder(); // 使用 StringBuilder 节约空间
        backtracking(n, 0, 0, builder);
        return ans;
    }

    // DFS
    public void backtracking(int n, int lb, int rb, StringBuilder path) {
        if (rb == n) { // 如果右括号数量到达 n
            ans.add(path.toString()); // 收集结果
            return;
        }
        // 与 for 循环不同的 DFS 操作，因为当前层左括号完毕之后要直接选择右括号了
        if (lb < n){
            backtracking(n, lb+1, rb, path.append("(")); // path + (  ，已经包括了回溯状态重置
            path.deleteCharAt(path.length()-1);
        }
        if (rb < n && rb < lb) { // 小于的话，最后加一个那就等于了
            backtracking(n, lb, rb+1, path.append(")"));
            path.deleteCharAt(path.length()-1);
        }

        // 尝试 for 看看行不行
        // 试过了，不行 2022年11月18日18:49:50
//        for (int i = lb; i < n; i++) {
//            backtracking(n, lb+1, rb, path.append("(")); // path + (  ，已经包括了回溯状态重置
//            path.deleteCharAt(path.length()-1);
//        }
//        for (int i = rb; i < n && i < lb; i++) {
//            backtracking(n, lb, rb+1, path.append(")"));
//            path.deleteCharAt(path.length()-1);
//        }
    }









/**
 * 错误写法
 */
//    List<String> ans = new ArrayList<>();
//    String path = "";
//    public List<String> generateParenthesis(int n) {
//        if (n < 1) {
//            return ans;
//        }
//        String string = bracketsInit(n);
//        backtracking(0, string, new byte[string.length()], path);
//        return ans;
//    }
//
//    public void backtracking(int startIndex, String s, byte[] used, String path) {
//        if (startIndex >= s.length()) {
//            ans.add(path);
//            return;
//        }
//        for (int i = startIndex; i < s.length(); i++) {
//            if (i > 0 && s.charAt(i-1) == s.charAt(i) && used[i-1] == 0) {
//                continue;
//            } else {
//                used[i] = 1;
//                backtracking(i+1, s, used, path + s.charAt(i));
//                used[i] = 0;
//            }
//        }
//    }
//
//    public String bracketsInit(int n) {
//        StringBuffer buffer = new StringBuffer();
//        for (int i = 0; i < n; i++) {
//            buffer.append("(");
//        }
//        for (int i = 0; i < n; i++) {
//            buffer.append(")");
//        }
//        return new String(buffer);
//    }
}
