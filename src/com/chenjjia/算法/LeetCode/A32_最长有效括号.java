package com.chenjjia.算法.LeetCode;

/**
 * Author：  chenjunjia
 * Date：    2022/9/24 15:09
 * WeChat：  China_JoJo_
 *
 * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 *
 * 示例 1：
 * 输入：s = "(()"
 * 输出：2
 * 解释：最长有效括号子串是 "()"
 *
 * 示例 2：
 * 输入：s = ")()())"
 * 输出：4
 * 解释：最长有效括号子串是 "()()"
 *
 * LeetCode 32
 * P22 10分00
 * tag：栈、字符串、DP
 */

/**
 * 这种涉及 “子串” 的题，首先想的是：i 位置的结果是多少，每个位置的答案是多少
 * 连续的问题，可以考虑滑动窗口
 * 这题可以考虑必须以 什么 为结尾，这题可以考虑必须用 ")" 结尾
 */

/**
 * 利用 pre 变量来往前跳
 * 而且要考虑 “接不接 pre-1” 位置的值
 */
public class A32_最长有效括号 {
    public static void main(String[] args) {
        System.out.println(longestValidParentheses("()()(())()(((())))"));
    }

    public static int longestValidParentheses(String s) {
        // dp[i] 代表的是：子串必须以 i 位置字符作为结尾，子串的最长长度有多大
        int[] dp = new int[s.length()];
        char[] chars = s.toCharArray();
        int res = 0;
        int pre = 0;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == ')') {
                /**
                 * (     [(     )]     )
                 *             i-1    i
                 * 肉眼可见 此时 i-1 = 2
                 * 那么 pre 就要来到 中括号那一坨 之前的一个位置：
                 *  (     [(     )]     )
                 * pre
                 */
                pre = i - dp[i - 1] - 1; // 先在这里跳一步，接下来的一步在后面跳（能跳则跳）当 dp[pre-1] 不为0，那就跳
                if (pre >= 0 && chars[pre] == '(') { // ① pre不越界 ; ② 在chars[pre] 的是'(' 与 chars[i] 的')' 相对应
                    dp[i] = dp[i - 1] + 2 // 如果到了这步，那么dp[i] 至少比 dp[i-1] 要多 2
                            + (pre > 0 ? dp[pre - 1] : 0); // 如果pre没越界，如果还能继续接，那就接，否则就 + 0
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
