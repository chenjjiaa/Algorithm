package com.chenjjia.算法.LeetCode;

/**
 * Author：  chenjunjia
 * Date：    2022/11/16 0:19
 * WeChat：  China_JoJo_
 * Blog：    https://juejin.cn/user/1856417285289304/posts
 * Github：  https://github.com/chenjjiaa
 */
public class A283_移动零 {
    public static void main(String[] args) {

    }

    public void moveZeroes(int[] nums) {
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            /**
             思路：如果fast指到0，slow不动，fast动
             fast指到不是0的，fast的值覆盖到slow上，然后slow++
             **/
            if (nums[fast] == 0) {
                continue;
            }
            nums[slow++] = nums[fast];
        }
        while (slow < nums.length) {
            nums[slow++] = 0;
        }
    }
}
