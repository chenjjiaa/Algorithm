package com.chenjjia.算法.LeetCode;

/**
 * Author：  chenjunjia
 * Date：    2022/11/18 20:42
 * WeChat：  China_JoJo_
 * Blog：    https://juejin.cn/user/1856417285289304/posts
 * Github：  https://github.com/chenjjiaa
 *
 * LeetCode：https://leetcode.cn/problems/word-search/
 */
public class A79_单词搜索 {

    /**
     * 使用了 used，空间复杂度：O(m * n)
     */
    public boolean exist(char[][] board, String word) {
        int i = board.length;
        int j = board[0].length;
        boolean[][] used = new boolean[i][j];
        /**
         * 每个位置都有可能作为出发点
         */
        for (int a = 0; a < i; a++) {
            for (int b = 0; b < j; b++) {
                if (dfs(board, a, b, 0, word, used)) {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean dfs(char[][] board, int i, int j, int index, String word, boolean[][] used) {
        if (index == word.length()) return true; // 这个忘了加，就不行了
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length
                || board[i][j] != word.charAt(index)
                || used[i][j]) {
            return false;
        }
        used[i][j] = true;
        boolean res = dfs(board, i-1, j, index+1, word, used) // index 记得 +1，这里的index回到本层也会自动回溯
                || dfs(board, i+1, j, index+1, word, used)
                || dfs(board, i, j-1, index+1, word, used)
                || dfs(board, i, j+1, index+1, word, used);
        used[i][j] = false;
        return res;
    }


    /**
     * 不用 used，空间复杂度：O(1)
     * 直接靠把原字符矩阵 board 的范围改超出26个大小写字母的范围即可
     * 因为输入的 word 有限制在字母范围，所以回溯的时候就不会将增加的范围误判
     */
    public boolean exist2(char[][] board, String word) {
        int i = board.length;
        int j = board[0].length;
        /**
         * 每个位置都有可能作为出发点
         */
        for (int a = 0; a < i; a++) {
            for (int b = 0; b < j; b++) {
                if (dfs2(board, a, b, 0, word)) {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean dfs2(char[][] board, int i, int j, int index, String word) {
        if (index == word.length()) return true; // 这个忘了加，就不行了
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length
                || board[i][j] != word.charAt(index)) {
            return false;
        }
        board[i][j] += 256; // 因为是char类型，所以可以直接转化，将本字符变成超越 word 字符的字母范围
        boolean res = dfs2(board, i-1, j, index+1, word)
                || dfs2(board, i+1, j, index+1, word)
                || dfs2(board, i, j-1, index+1, word)
                || dfs2(board, i, j+1, index+1, word);
        board[i][j] -= 256; // 状态复原
        return res;
    }
}
