package com.chenjjia.算法.LeetCode;

/**
 * Author：  chenjunjia
 * Date：    2022/11/16 10:55
 * WeChat：  China_JoJo_
 * Blog：    https://juejin.cn/user/1856417285289304/posts
 * Github：  https://github.com/chenjjiaa
 */
public class A137_只出现一次的数字II {
    public static void main(String[] args) {

    }

    /**

     整数最多是32位，n 个数字都去遍历一遍个个位置上的 1 的个数
     如果能整除 3，则不是要的答案。例如这个数组 {2,1,2,2} 的二进制位信息是
     1   0 （nums[0]数字）
     0   1 （nums[1]数字）
     1   0 （nums[2]数字）
     1   0 （nums[3]数字）
     -----------
     3   1  ---> count

     **/
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < 32; i++) { // 统计每一位 1 的个数
            int count = 0;
            for (int j = 0; j < nums.length; j++) { // 遍历每个数字，只要这个位的数字是1就累加
                count += (nums[j] >> i) & 1;
            }
            if (count % 3 == 1) { // 找到了只出现一次的数字
                // 将他还原（将这一位的还原。如果count = 0，则进不来）
                res |= (1 << i);
            }
        }
        return res;
    }
}
