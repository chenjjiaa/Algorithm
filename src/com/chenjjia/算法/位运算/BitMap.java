package com.chenjjia.算法.位运算;

/**
 * Author：  chenjunjia
 * Date：    2022/8/17 16:47
 * WeChat：  China_JoJo_
 *
 * 场景：判断 0 ~ 42E 的数字，哪个出现了，哪个没出现。要求空间不大于 1G
 * 已知 int 类型占 4B，long 类型占 8B
 */
public class BitMap {
    public static void main(String[] args) {

        //↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓ 判断某位上是否为1（下面的例子是判断 2 位置的 bit 是否为 1）。三个等效，但第一个更好
        System.out.println((4 >> 2) & 1);
        System.out.println(4 & (1 << 2));
        System.out.println((4 & (1 << 2)) != 0);
        //↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑
        System.out.println("===================");

        int[] arr = new int[10]; // 这里能代表 0 ~ 319 个数字的出现信息。因为 int[10] = 40B = 320bit
        int i = 178;
        // 将 i 号位改成 1
        int arrIndex = i / 32;
        int bitIndex = i % 32;
        arr[arrIndex] |= 1 << bitIndex;
        // 判断 i 号位是否已经改成 1
        boolean exist = ((arr[arrIndex] >> bitIndex) & 1) == 1;
        // 将 i 号位改成 0
        arr[arrIndex] &= ~ (1 << bitIndex);
    }
}
