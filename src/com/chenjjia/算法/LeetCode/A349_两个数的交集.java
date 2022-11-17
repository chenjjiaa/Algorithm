package com.chenjjia.算法.LeetCode;

import java.util.HashSet;

/**
 * Author：  chenjunjia
 * Date：    2022/11/17 3:06
 * WeChat：  China_JoJo_
 * Blog：    https://juejin.cn/user/1856417285289304/posts
 * Github：  https://github.com/chenjjiaa
 */
public class A349_两个数的交集 {

    public static int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet();
        HashSet<Integer> resultSet = new HashSet();
        int i = 0;
        int index = 0;
        for (int num : nums1) {
            set.add(num);
        }
        for (int num : nums2) {
            if (set.contains(num))
                resultSet.add(num);
        }
        int[] ans = new int[resultSet.size()];
        for (int num : resultSet){
            ans[index++] = num;
        }
        return ans;
    }
}
