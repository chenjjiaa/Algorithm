package com.chenjjia.算法.LeetCode;

/**
 * Author：  chenjunjia
 * Date：    2022/11/13 22:22
 * WeChat：  China_JoJo_
 * Blog：    https://juejin.cn/user/1856417285289304/posts
 * Github：  https://github.com/chenjjiaa
 *
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 *
 * 示例 2：
 * 输入：nums = [0,1,2,2,3,0,4,2], val = 2
 * 输出：5, nums = [0,1,4,0,3]
 * 解释：函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。
 * 注意这五个元素可为任意顺序。你不需要考虑数组中超出新长度后面的元素。
 */
public class A27_移除元素 {
    public static void main(String[] args) {
        System.out.println(removeElement(new int[]{0,1,2,2,3,0,4,2}, 2));
    }

    /**
     * 双指针解法
     * @return 返回新数组的 length
     */
    public static int removeElement(int[] nums, int val) {
        int slow = 0; // slow 指向的是新数组下标的位置，同时也是要替换的位置
        for (int fast = 0; fast < nums.length; fast++) {
            // 如果此时是要删除的元素
            if (val == nums[fast]) continue; // 直接跳到下一个位置
            nums[slow++] = nums[fast]; // 将符合条件的数值覆盖到slow下标的位置上
        }
        return slow;
    }

    public static int removeElement2(int[] nums, int val) {
        int slowIndex = 0;
        for (int fastIndex = 0; fastIndex < nums.length; fastIndex++) {
            if (nums[fastIndex] != val) nums[slowIndex++] = nums[fastIndex];
        }
        return slowIndex;
    }
}
