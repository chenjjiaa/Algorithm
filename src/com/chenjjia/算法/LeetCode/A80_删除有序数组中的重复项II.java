package com.chenjjia.算法.LeetCode;

/**
 * Author：  chenjunjia
 * Date：    2022/11/15 0:20
 * WeChat：  China_JoJo_
 * Blog：    https://juejin.cn/user/1856417285289304/posts
 * Github：  https://github.com/chenjjiaa
 */
public class A80_删除有序数组中的重复项II {
    public static void main(String[] args) {

    }

    /**
     * 这题虽是保留2位重复值，但解法同样使用于在有序数组中【保留K位】
     */
    public static int removeDuplicates(int[] nums) {
        if (nums.length < 2) return nums.length;
        int slow = 2; // 也就是保留 K 位的数
        for (int fast = 2; fast < nums.length; fast++) {
            if (nums[slow-2] < nums[fast]) // slow-2 是管着后面k位的数值，前k位刚刚好失效
                nums[slow++] = nums[fast];
            /** 假如中了这里的 else 语句
             *  如果 fast 还不比 slow 掌管的区域的数值大，那么 fast 就要寻找更大的数了，
             *  而 slow 要保持在原地等待 fast 找到比 slow 掌管要过期的数字更大的数
             */
        }
        return slow;
    }
}
