package com.chenjjia.算法.LeetCode;

/**
 * Author：  chenjunjia
 * Date：    2022/11/11 23:24
 * WeChat：  China_JoJo_
 * Blog：    https://juejin.cn/user/1856417285289304/posts
 * Github：  https://github.com/chenjjiaa
 */
public class A121_买卖股票的最佳时机_DP_贪心_枚举 {
    public static void main(String[] args) {
        System.out.println(maxProfit1(new int[]{7,6,5,4,3}));
    }

    /**
     * 暴力枚举
     */
    public static int maxProfit1(int[] prices) {
        int res = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) { // j 要在 i+1 开始，一定要保证在 i 后面
                res = Math.max(res, prices[j] - prices[i]);
            }
        }
        return res;
    }

    /**
     * 贪心
     * 取最左最⼩值，取最右最大值，那么得到的差值就是最大利润
     */
    public static int maxProfit2(int[] prices) {
        int low = Integer.MAX_VALUE;
        int res = 0;
        for (int i = 0; i < prices.length; i++) {
            low = Math.min(low, prices[i]); // 时刻记录着左侧最小值
//            if (prices[i] > low) {
                res = Math.max(res, prices[i] - low);
//            }
        }
        return res;
    }

    /**
     * DP
     */
    public static int maxProfit3(int[] prices) {
        int res = 0;
        return res;
    }
}
