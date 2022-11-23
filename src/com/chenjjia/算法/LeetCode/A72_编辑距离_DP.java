package com.chenjjia.算法.LeetCode;

/**
 * Author：  chenjunjia
 * Date：    2022/11/18 12:02
 * WeChat：  China_JoJo_
 * Blog：    https://juejin.cn/user/1856417285289304/posts
 * Github：  https://github.com/chenjjiaa
 *
 * LeetCode：https://leetcode.cn/problems/edit-distance/
 */
public class A72_编辑距离_DP {

    /**
     * 这题很重要，年年考！
     * 这题和最长公共子序列、最长公共子串是同一个模型
     * 两个字符串分别做行做列的模型
     *
     * 在工程上也经常使用，比如搜索不可能严格精确的匹配
     * 如果搜不到，就在数据库里搜一批编辑距离比较短的数据
     * 编辑距离算法可以近似的描述两个字符串的相似度
     */

    /**
     * 这题的尝试模型是：两个样本分别 做行、做列的尝试
     */
    public int minDistance(String a, String b) {
        // 1、dp[i][j] 的含义是：长度为 i 的字符串，要变成长度为 j 的字符串，所需的代价
        int[][] dp = new int[a.length()+1][b.length()+1];
        /**
         * 2、递推公式：
         *   分为两个大情况
         *      1、 a[i] == b[j]，那么这种情况不用操作
         *      那就是各自上一个长度的编辑距离，也就是 dp[i][j] = dp[i-1][j-1]
         *
         *      2、 a[i] != b[j]，那么有三种处理方式：添加、删除、替换
         *          2.1、【新增】那么在 a 字符串后面新增，那就又相当于最后一个字符 == b[j] 了（构造了第一种相等的情况）
         *               那么 i 不变，j 是 j-1 的步数
         *               那么此时的公式为：dp[i][j] = dp[i][j-1] + 1（因为新增了所以 +1）
         *          2.2、【删除】因为是在 i 上删除，所以 a 此时只剩 i-1
         *               此时递推公式为：dp[i][j] = dp[i-1][j] + 1（删除操作 +1）
         *          2.3、【替换】因为将 i 替换成 j，使得他们两个相等，又变成了第一种情况
         *               此时递推公式为：dp[i][j] = dp[i-1][j-1] + 1（替换操作）
         *      第二大类的三种情况取最小值即可：Math.min(三条递推公式)
         */
        // 3、dp 数组初始化
        for (int i = 0; i < dp.length; i++) {   // 初始化纵向
            dp[i][0] = i; // 空串到 dp[i][0] 的代价是 i
        }
        for (int i = 0; i < dp[0].length; i++) { // 初始化横行
            dp[0][i] = i; // 空串到 dp[0][i] 的代价是 i
        }
        // 4、开始遍历，从上往下，从左往右遍历（而且要注意！遍历要从有效位开始！）
        for (int i = 1; i <= a.length(); i++) { // 有效位从 1 开始
            for (int j = 1; j <= b.length(); j++) { // 有效位从 1 开始
                if (a.charAt(i-1) == b.charAt(j-1)) { // 第一种情况，记得 -1
                    dp[i][j] = dp[i-1][j-1];
                } else { // 第二种情况，三种编辑小分类取最小值
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i][j-1], dp[i-1][j])) + 1;
                }
            }
        }
        return dp[a.length()][b.length()];
    }
}
