package com.chenjjia.算法.位运算;

/**
 * Author：  chenjunjia
 * Date：    2022/8/26 11:25
 * WeChat：  China_JoJo_
 *
 * 给定两个有符号 32位整数 a和 b，返回 a和 b中较大的。
 * 要求：不用做任何比较判断。
 *
 * 利用加号，把互斥条件的 if-else 写成数学的形式
 */
public class 比较两数大小 {
    public static void main(String[] args) {
        System.out.println(getMax2(10,2));
//        System.out.println(Integer.toBinaryString(0x55555555));
//        System.out.println("1010101010101010101010101010101".length());
    }
    
    /**
     * 此方法的缺点是可能会导致大小溢出
     * 负数减正数的情况 有可能会导致溢出
     */
    public static int getMax1(int a, int b) {
        int isPositive = sign(a - b); // a - b 的符号
        int isNegative = flip(isPositive); // 若 a-b 为正数，则这个数为 0
        return a * isPositive + b * isNegative; // 互斥
    }

    /**
     * 溢出无影响的增强版
     */
    public static int getMax2(int a, int b) {
        int c = a - b;
        int signA = sign(a);
        int signB = sign(b);
        int signC = sign(c);
        int difAB = signA ^ signB; // ab符号不一样，同 0 异 1
        int sameAB = flip(difAB); // 和 difAB 互斥
        /**
         * 条件1、符号不同的情况且 a 为正数
         * 条件2、符号相同的情况下 a-b 不会溢出，差值符号是非负
         */
        int returnA = difAB * signA + sameAB * signC;
        int returnB = flip(returnA);
        return a * returnA + b * returnB;
    }

    /**
     * 获取当前数的符号
     * @return 正数返回 1，负数返回 0
     */
    public static int sign(int n) {
        return flip((n >> 31) & 1);
    }


    public static int flip(int n) {
        return n ^ 1;
    }

}
