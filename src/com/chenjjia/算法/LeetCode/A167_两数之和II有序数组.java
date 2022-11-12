package com.chenjjia.算法.LeetCode;

/**
 * Author：  chenjunjia
 * Date：    2022/11/12 14:49
 * WeChat：  China_JoJo_
 * Blog：    https://juejin.cn/user/1856417285289304/posts
 * Github：  https://github.com/chenjjiaa
 *
 * 给你一个下标从 1 开始的整数数组 numbers ，该数组已按 非递减顺序排列
 * 请你从数组中找出满足相加之和等于目标数 target 的两个数。
 * 如果设这两个数分别是 numbers[index1] 和 numbers[index2] ，
 * 则 1 <= index1 < index2 <= numbers.length 。
 * 以长度为 2 的整数数组 [index1, index2] 的形式返回这两个整数的下标 index1 和 index2。
 * 你可以假设每个输入 只对应唯一的答案 ，而且你 不可以 重复使用相同的元素。
 *
 * 限制：空间复杂度 O(1)
 *
 * LeetCode：https://leetcode.cn/problems/two-sum-ii-input-array-is-sorted/
 */


public class A167_两数之和II有序数组 {
    public static void main(String[] args) {
        int[] ints = twoSum(new int[]{0, 5}, 5);
        System.out.println(ints[0] + "," + ints[1]);
    }

    /**
     * 双指针法
     * 思路：因为数组有序
     * 第一种情况：先从最小 + 最大开始，若和大于 target，说明 right + arr_min 不满足条件了
     * 那么 left 往上移动就更加不符合条件，因此要将 right 向下移动 使他变小
     * 因为此时 left = 数组最小值，也就是 arr_min
     *
     * 第二种情况：向下移动了 right，若和小于 target
     * 那就说明，arr_min + 比 right 小的，都会小于 target
     * 那么要将 left 向上移动 使 left 变大
     *
     * 第三种情况：和 == target，直接返回 left，right 下标即可
     */
    public static int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int temp = numbers[left] + numbers[right];
            if (temp > target) {
                right--;
            }
            if (temp == target) {
                return new int[] {left, right};
            }
            if (temp < target) {
                left++;
            }
        }
        return new int[]{0};
    }
}
