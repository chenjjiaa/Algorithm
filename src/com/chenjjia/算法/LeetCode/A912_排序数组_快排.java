package com.chenjjia.算法.LeetCode;

/**
 * Author：  chenjunjia
 * Date：    2022/11/18 14:48
 * WeChat：  China_JoJo_
 * Blog：    https://juejin.cn/user/1856417285289304/posts
 * Github：  https://github.com/chenjjiaa
 */
public class A912_排序数组_快排 {

    public int[] sortArray(int[] nums) {
        if (nums == null || nums.length < 2) {
            return nums;
        }
        quikSort(nums, 0, nums.length-1);
        return nums;
    }

    /**
     随机快排
     */
    public void quikSort(int[] nums, int left, int right) {
        if (left <= right) {
            // 随机交换最后一个数字的值
            swap(nums, left + (int)Math.random()*(right-left+1), right);
            // partition
            int[] p = partition(nums, left, right);
            // 对小于区域、大于区域的范围进行快排
            quikSort(nums, left, p[0]-1);
            quikSort(nums, p[1]+1, right);
        }
    }
    /**
     * @param r 随机挑选出来的基准数，作为荷兰国旗问题的 target值
     * @return int[] 数组包含两个数：划分值相等的左边界和右边界下标
     */
    public int[] partition(int[] arr, int l, int r) {
        int less = l-1; // 小于区域的前一个位置
        int more = r+1; // 大于区域的后一个位置
        int target = arr[r];
        while (l < more) {
            if (arr[l] < target) {
                swap(arr, ++less, l++);
            } else if (arr[l] == target) {
                l++;
            } else {
                swap(arr, l, --more);
            }
        }
        return new int[] {less+1, more-1};
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
