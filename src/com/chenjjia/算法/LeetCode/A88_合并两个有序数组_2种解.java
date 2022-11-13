package com.chenjjia.算法.LeetCode;

/**
 * Author：  chenjunjia
 * Date：    2022/11/13 13:02
 * WeChat：  China_JoJo_
 * Blog：    https://juejin.cn/user/1856417285289304/posts
 * Github：  https://github.com/chenjjiaa
 */
public class A88_合并两个有序数组_2种解 {
    public static void main(String[] args) {

    }

    /**
     * 优化版：不用辅助数组，降低空间复杂度
     * 看了下评论区，真是神仙云集，从后向前遍历的方法实在是妙极了！
     * 逆向思维真的很重要……
     * 空间复杂度 O(1)
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = m + n - 1; // 作为大数组的尾指针
        m--; // nums1[]的有效区
        n--; // nums2[]的有效区
        while(n >= 0) { // 若 nums2[] 还有元素
            if(m > -1 && nums1[m] > nums2[n]) { // 若 nums1[m] 元素大于 nums2 的，其中要注意 m 的越界判断
                nums1[index] = nums1[m--]; // 将 num1[m] 的位置往后挪
            } else { // 否则将 nums2[] 的值赋值给 nums1[index]
                nums1[index] = nums2[n--];
            }
            index--;
        }
    }

    /**
     * 辅助数组版，空间复杂度 O(n)
     */
    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        int[] temp = new int[m+n]; // 临时存放的数组
        int c1 = 0; // nums1的指针
        int c2 = 0; // nums2的指针
        int i = 0;
        while(c1 < m && c2 < n) {
            if(nums1[c1] <= nums2[c2]) {
                temp[i] = nums1[c1];
                i++;
                c1++;
            } else {
                temp[i] = nums2[c2];
                i++;
                c2++;
            }
        }
        while(c1 < m) { // 谁还没放完就放谁
            temp[i] = nums1[c1];
            i++;
            c1++;
        }
        while(c2 < n) { // 谁还没放完就放谁
            temp[i] = nums2[c2];
            i++;
            c2++;
        }
        // nums1 = temp; // 数组不能这样子直赋值
        for(int j = 0; j < nums1.length; j++) {
            nums1[j] = temp[j];
        }
    }
}
