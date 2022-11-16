package com.chenjjia.算法.LeetCode;

import java.util.*;

/**
 * Author：  chenjunjia
 * Date：    2022/11/16 22:07
 * WeChat：  China_JoJo_
 * Blog：    https://juejin.cn/user/1856417285289304/posts
 * Github：  https://github.com/chenjjiaa
 */
public class A17_电话号码的字母组合 {

    /**
     这道题涉及了两个集合的问题
     前面的题目都是一个集合里面的组合问题
     所以本题和 【77组合】、【216组合总和III】的startIndex 稍微有些不一样
     而两个集合中的元素两两结合的话，复杂度就涉及到笛卡尔积的问题了
     */
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return ans;
        }
        String[] stringMap = {
                "",
                "",
                "abc",
                "def",
                "ghi",
                "jkl",
                "mno",
                "pqrs",
                "tuv",
                "wxyz",
        };
        backtracking(digits, ans, "", 0, stringMap);
        return ans;
    }

    /**
     * @param digits 输入的数字字符串，如："234"，不同的数字代表不同的集合
     * @param path   沿途做的决定
     * @param ans    返回结果
     * @param index  digits 的下标，可以用来获取 stringMap 对应下标的值
     */
    public void backtracking(String digits, List<String> ans, String path, int index, String[] stringMap) {
        if (index == digits.length()) {
            ans.add(path); // 因为字符串是不可变的，可以直接存，不用重新new一个String
            return;
        }
        // 根据digits字符串数字中获取当前集合，这千万不能放在循环中啊，要不然在循环的时候会选择别的元素
        String temp = stringMap[digits.charAt(index) - '0']; // 比如获取到 '1' - '0'  ---> 1下标
        for (int i = 0; i < temp.length(); i++) { // i不能从index开始，因为不是同一个集合的去重问题，所以不用控制本集合内的
            // 从当前集合选择一个元素，成为本次的决定
            // path = path + temp.charAt(i);
            // 然后进行递归，去下一个集合去选择下一个元素
            // backtracking(digits, ans, path, index + 1, stringMap);
            backtracking(digits, ans, path + temp.charAt(i), index + 1, stringMap);
            // 撤销从当前集合选择的决定
            // path.substring(0, path.length() - 1);
        }
    }
}
