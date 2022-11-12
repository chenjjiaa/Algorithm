package com.chenjjia.算法.LeetCode;

import java.util.HashMap;

/**
 * Author：  chenjunjia
 * Date：    2022/11/10 22:00
 * WeChat：  China_JoJo_
 * Blog：    https://juejin.cn/user/1856417285289304/posts
 * Github：  https://github.com/chenjjiaa
 */
public class A05_最长回文子串_Manacher {
    public static void main(String[] args) {
//        System.out.println(longestPalindrome("有一句话是这样说的：上海自来水来自海上"));
        System.out.println(longestPalindrome("babad"));
//        System.out.println("123456789".substring(0,1));
    }

    public static int longestPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        char[] manacherString = getManacherString(s);
        int[] pArr = new int[manacherString.length];
        int R = -1; // 扩展到的最右侧的下一个位置，R-1 是回文有效区域，R 更新，C 一定更新
        int C = -1; // 更新 R 时的下标位置，也就是当时的中心
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < manacherString.length; i++) {
            // 判断 i 回文半径在不在 R 里，不在就更新
            if (i + pArr[i] > R) {
                R = i + pArr[i]; // i 的回文半径将 R 往后推
                C = i;
            }
            // 确定 pArr[] 不用验的区域
            pArr[i] = i > R ? 1 : Math.min(R - i, pArr[2 * C - i]);
            // 确定好不用验的区域之后，就可以继续选择扩充了/或暴力扩
            while (i - pArr[i] > -1 && i + pArr[i] < pArr.length) {
                if (manacherString[i + pArr[i]] == manacherString[i - pArr[i]]) {
                    pArr[i]++;
                } else {
                    break;
                }
            }
            max = Math.max(max, pArr[i]);
        }
        int max1 = 0;
        int index = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < pArr.length; i++) {
            if (pArr[i] > max1) {
                max1 = pArr[i];
                map.put(max1, i);
                index = i;
            }
        }
        System.out.println(s.substring((index/2) - (pArr[index] / 2 - 1), (index/2) + (pArr[index] / 2)));
        return max - 1;
    }

    public static char[] getManacherString(String s) {
        if (s == null || s.isEmpty()) {
            return null;
        }
        char[] manacherArray = new char[s.length() * 2 + 1];
        for (int i = 0; i < manacherArray.length; i++) {
            if ((i & 1) == 0) {
                manacherArray[i] = '#';
            } else {
                manacherArray[i] = s.charAt(i/2);
            }
        }
        return manacherArray;
    }

    private static void printArray(int[] arr) {
        System.out.println("打印开始===============");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "  ");
        }
        System.out.println();
        System.out.println("打印结束===============");
    }

    private static void printCharArray(char[] arr) {
        System.out.println("打印开始===============");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "  ");
        }
        System.out.println();
        System.out.println("打印结束===============");
    }
}
