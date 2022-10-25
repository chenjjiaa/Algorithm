package com.chenjjia.算法;

/**
 * Author：  chenjunjia
 * Date：    2022/8/23 9:55
 * WeChat：  China_JoJo_
 *
 * 字符串 str1 和 str2，str1 是否包含 str2，如果包含返回 str2 在 str1 中开始的位置。
 *
 * P13 1小时28分04秒
 */
public class KMP_最长子串问题 {
    public static void main(String[] args) {
        System.out.println(getIndexOf("abbastabbaxxabbastabbaf", "abbaf"));
        System.out.println("abbastabbaxxabbastabbaf".indexOf("abbaf"));
    }

    /**
     * 在整个判断过程中，str1 的 index移动是一直向前的，而 str2的移动是可以向前移动的，以此来加速判断
     */
    public static int getIndexOf(String str1, String str2) {
        if (str1 == null || str2 == null || str1.isEmpty() || str2.isEmpty() || str2.length() > str1.length()) {
            return -1;
        }
        int[] nextArray = getNextArray(str2.toCharArray());
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        int i1 = 0;
        int i2 = 0;
        while (i1 < chars1.length && i2 < chars2.length) {
            if (chars1[i1] == chars2[i2]) {
                i1++;
                i2++;
            } else if (nextArray[i2] == -1) { // 跳到不能跳了
                i1++;
            } else { // 能跳则跳
                i2 = nextArray[i2];
            }
        }
        // 返回 str2 在 str1 中开始的位置
        return i2 == str2.length() ? i1 - i2 : -1;
    }

    /**
     * 生成 next 数组
     * KMP算法的精髓就是这个数组的生成
     *
     * next 数组：当前字符的最长前后缀的长度，不包含前面所有字符的总长度
     * 例如：a  b  a  s  t  a  b  a  x  ---> 原字符串
     *     -1  0  0  1  0  0  1  2  3  ---> next数组
     *      其中 x 的 next 数组对应的数值是 next[index] == 3
     */
    public static int[] getNextArray(char[] chars) {
        if (chars.length < 2) {
            return new int[] {-1};
        }
        int[] nextArray = new int[chars.length];
        nextArray[0] = -1;
        nextArray[1] = 0;
        int cn = 0; // 要拿哪个字符和 i-1 的字符比，
        for (int i = 2; i < chars.length;) {
            if (chars[i-1] == chars[cn]) { // 若i-1位置和最长前缀位置字符相同
                nextArray[i++] = ++cn; //
            } else if (cn > 0) { // 如果不同，则跳到 cn 的最长前缀处
                /**
                 *                             i-1  i
                 * 例如：a  b  a  s  t  a  b  a  x   f
                 *     -1  0  0  1  0  0  1  2  3  ---> next数组
                 * 在这里 i-1 和 s对比
                 *       x != s
                 *       然后 cn 移动到 1
                 *       x != b
                 *       cn 移动到 a
                 *       x != a
                 *       然后 f 对应的 next[f_index] = 0
                 */
                cn = nextArray[cn];
            } else { // cn 来到了数组开头，不能再往前了，此时值为0，因为没有任何可以与它匹配的前后缀
                nextArray[i++] = 0;
            }
        }
        return nextArray;
    }
}
