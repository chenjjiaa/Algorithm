package com.chenjjia.算法.LeetCode;

import java.util.LinkedList;

/**
 * Author：  chenjunjia
 * Date：    2022/11/14 2:08
 * WeChat：  China_JoJo_
 * Blog：    https://juejin.cn/user/1856417285289304/posts
 * Github：  https://github.com/chenjjiaa
 */
public class A239_滑动窗口最大值 {
    public static void main(String[] args) {

    }

    /**
     本题可以用双端队列
     双端队列中放数组下标，因为数组下标能比数组代表的信息多
     如果是最大值更新结构，双端队列从头到尾，要保证数字从大到小
     任何时候窗口内的的最大值，都是双端队列头部代表的值

     当 R 往右动：
     每个数字都是从尾部进，而且不能破坏双端队列的单调性
     若队列中的数字比当前数小，则要将队列中的数弹出，直至符合单调性条件为止
     当 L 往右动：
     如果 L 让双端队列头部的数字过期，那么从双端队列头部弹出该数字
     因为双端队列中存放的是下标，所以很容易更新，很容易获取新的最大值
     （根据新头部的下标，在 nums[] 中获取即可）

     双端队列维持的信息是：
     如果 R 不动，如果让 L 往右动，此时谁能依次成为窗口内的最大值的这个信息
     也就是如果窗口会过期，会成为最大值的可能性

     为什么新的数字比队列中的大，要将队列的小数字弹出？因为这个数字再也没有机会变成最大值了
     因为我的下标比你晚过期，我的值还比你大，你不让位，谁让位？所以你走就行了
     相当于我比你年轻，技术比你强，你退休吧！
     **/
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length < 2) {
            return nums;
        }
        int[] res = new int[nums.length - k + 1];
        LinkedList<Integer> queue = new LinkedList<>(); // 用双向链表作为双端队列
        int index = 0; // 返回结果集的下标
        for (int right = 0; right < nums.length; right++) {
            // 如果此时要添加进去的元素大于queue里的元素，先将queue中元素弹出至符合条件
            while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[right]) {
                queue.pollLast();
            }
            queue.addLast(right);
            // 判断是否过期，如果下标过期了，就删除queue头的元素就行了
            if (queue.peekFirst() == right - k) {
                queue.pollFirst();
            }
            // 判断是否形成窗口，形成窗口之后才将最大值填充进 res 返回结果集
            if (right - k + 1 >= 0) {
                res[index++] = nums[queue.peekFirst()];
            }
        }
        return res;
    }
}
