package com.chenjjia.算法.LeetCode;

import java.util.*;

/**
 * Author：  chenjunjia
 * Date：    2022/11/16 13:28
 * WeChat：  China_JoJo_
 * Blog：    https://juejin.cn/user/1856417285289304/posts
 * Github：  https://github.com/chenjjiaa
 */

/**
 * 【bug描述】
 * 输出的值全是空
 * 原因：在返回结果集直接添加了 path
 * 而 path 后面是要进行 “状态重置” ，最后为空
 * 而结果集那就保存了这个 path 的引用，引用里面的数据为空，结果集自然为空
 */
public class A77_组合_回溯剪枝 {
    public static void main(String[] args) {
        List<List<Integer>> combine = combine(4, 2);
        printLists(combine);
        System.out.println(combine.size());
    }


    // 回溯
    public static List<List<Integer>> combine(int n, int k) {
        LinkedList<Integer> queue = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
        backtracking(n, k, 1, queue, ans);
        return ans;
    }

    public static void backtracking(int n, int k, int start, LinkedList<Integer> queue, List<List<Integer>> ans) {
        if (k == queue.size()) { // 后续数字不足那就直接返回，或者收集满了也返回
//            ans.add(queue); // 因为这里如果直接添加queue，这里加进去的值是queue的引用，queue最终为空
            ans.add(new ArrayList<>(queue)); // 所以要将queue的值拷贝到新数组加入到结果集
            return;
        }
        for (; start <= n-(k-queue.size())+1; start++) {
            /**

             (k - queue.size()) // 还需多少个元素
             n - (k - queue.size()) + 1 // 下标至多能到的地方

             */
            queue.add(start);
            backtracking(n, k, start+1, queue, ans);
            // 回溯操作
            queue.remove(queue.size()-1);
        }
    }

    public static void printLists(List<List<Integer>> lists) {
        for (List<Integer> list : lists) {
            for (Integer num : list) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
