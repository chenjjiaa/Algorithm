package com.chenjjia.算法.LeetCode;

import java.util.Stack;

/**
 * Author：  chenjunjia
 * Date：    2022/11/13 21:44
 * WeChat：  China_JoJo_
 * Blog：    https://juejin.cn/user/1856417285289304/posts
 * Github：  https://github.com/chenjjiaa
 */
public class A150_逆波兰表达式求值 {
    public static void main(String[] args) {
        System.out.println(evalRPN(new String[]{"2","1","+","3","*"}));
    }

    // 逆波兰表达式其实是一个树的后序遍历、
    // 但这道题简单就简单在：不用将字符串先转化为后缀表达式
    // 1、遇到数字就放栈里
    // 2、遇到算术运算符就弹出两个数字计算，然后再压入栈中
    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        while(i < tokens.length) {
            if(tokens[i] == "+" || tokens[i] == "-" || tokens[i] == "*" || tokens[i] == "/") {
                int num1 = stack.pop();
                int num2 = stack.pop();
                if(tokens[i] == "+") {
                    stack.push(num1 + num2);
                }
                if(tokens[i] == "-") {
                    stack.push(num2 - num1); // num2 在前面
                }
                if(tokens[i] == "*") {
                    stack.push(num1 * num2);
                }
                if(tokens[i] == "/") {
                    stack.push(num2 / num1); // num2 在前面
                }
            } else {
                stack.push(Integer.parseInt(tokens[i]));
            }
            i++;
        }
        return stack.pop();
    }
}
