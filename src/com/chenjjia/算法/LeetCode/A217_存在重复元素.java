package com.chenjjia.算法.LeetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * Author：  chenjunjia
 * Date：    2022/11/15 22:11
 * WeChat：  China_JoJo_
 * Blog：    https://juejin.cn/user/1856417285289304/posts
 * Github：  https://github.com/chenjjiaa
 */
public class A217_存在重复元素 {
    public static void main(String[] args) {

    }

    /**
     1、暴力尝试 双重循环
     2、哈希表，但空间复杂度比较高
     3、set，和哈希表类似，如果重复添加，会返回 false
     4、其实可以用数组，如果输入的数字有限制的话（比如输入数据中不含0）
     这种情况 就可以将索引和数字一一对应，比如3放在3号位上
     下次添加时，如果这个位置有元素，那就返回false
     */
    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.add(nums[i]) == false) // 如果重复添加，会返回 false
                return true;
        }
        return false;
    }
}
