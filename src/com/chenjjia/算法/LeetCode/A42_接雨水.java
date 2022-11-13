package com.chenjjia.算法.LeetCode;

/**
 * Author：  chenjunjia
 * Date：    2022年11月13日02:07:52
 * WeChat：  China_JoJo_
 *
 * P24 38分40秒
 * 双指针讲解部分：49:20
 */

/**
 * 解题思路：每个位置都只关心自己上方能接多少水（类似物理的水下压强，取决于水的深度而已）
 *
 * 10 ） i位置 （ 20  ---->  此时 i 位置能接 5格水
 * 就类似洗衣机问题，关系的是 i位置左边要扔多少衣服，右边要扔多少衣服
 */

/**
 * 方法一 ：使用两个辅助数组，分别记录每个位置左边最大值、右边最大值
 * 将所有位置的 i位置的左侧最大值，记在一个数组里
 * i位置右侧最大值，记在一个数组里
 * 方法一缺点 ：因为使用辅助数组，所以空间复杂度是 O(N)
 *
 * 方法二 ：双指针方法
 * 难点是要发觉题目的数据状况。比如只需要记录 i位置一左一右的最大值即可。
 * 然后就可以用现有的几个变量来完成解题
 * 空间复杂度 O(1)
 */
public class A42_接雨水 {
    public static void main(String[] args) {
        int[] height = new int[] {4,2,0,3,2,5};
        int trap = trap(height);
        System.out.println(trap);
    }

    /**
     * 双指针
     */
    public static int trap(int[] height) {
        if (height.length < 3) {
            return 0;
        }
        int lMax = height[0];
        int rMax = height[height.length-1];
        int left = 0; // 左指针从 0 开始
        int right = height.length-1; //
        int res = 0;

        while (left < right) {
            lMax = Math.max(lMax, height[left]);  // 若左边出现了更大的值，更新左max
            rMax = Math.max(rMax, height[right]); // 若右边出现了更大的值，更新右max
            if (lMax < rMax) { // 结算左边
                res += Math.max(0, lMax-height[left]);
                left++;
            } else {
                // 结算右边
                res += Math.max(0, rMax-height[right]);
                right--;
            }
        }
        return res;
    }
}
