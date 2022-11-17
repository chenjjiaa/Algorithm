package com.chenjjia.算法.LeetCode;

import java.util.*;

/**
 * Author：  chenjunjia
 * Date：    2022/11/17 13:01
 * WeChat：  China_JoJo_
 * Blog：    https://juejin.cn/user/1856417285289304/posts
 * Github：  https://github.com/chenjjiaa
 */
public class A93_复原IP地址 {

//    List<String> ans = new ArrayList<>();
//    public List<String> restoreIpAddresses1(String s) {
//        if (s == null || s.length() == 0) {
//            return ans;
//        }
//        backtracking(s, 0, 0);
//        return ans;
//    }
//
//    public void backtracking(String s, int startIndex, int pointCount) {
//        if (pointCount == 3) {
//            if (isValid(s, startIndex, s.length()))
//                ans.add(new String(s));
//            return;
//        }
//        for (int i = startIndex; i < s.length(); i++) {
//            // 判断切割区间是否合法，这里已经相当于是剪枝了
//            if (isValid(s, startIndex, i+1)) {
//                s = s.substring(0, startIndex + 1) + "," + s.substring(startIndex); // 加个逗号
////                pointCount += 1; // 加了逗号，count + 1
//                // 因为从当前位置切割，加上了逗号，所以要i+2，pointCount的回溯可以在这里的入参完成
//                backtracking(s, i+2, pointCount+1);
////                pointCount -= 1;
//                s = s.substring(0, startIndex + 1) + s.substring(startIndex + 2);
//            }
//        }
//    }

    //=============================================================
    List<String> path = new ArrayList<>();
    List<String> resultList = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        if (s.length() > 12 || s.length() < 4 || s == null)
            return resultList;
        backtrack(s, 0);
        return resultList;
    }

    /**
     这题切割，就是要考虑子串的处理，子串的验证，和子串的拼接
     跟着评论区老哥的代码敲的
     bug：回溯函数的 base case 条件写错了
     startIndex == 4 改成 path.size() == 4
     */
    private void backtrack(String s, int startIndex) {
        if (path.size() == 4 && startIndex != s.length()) return;
        if (path.size() == 4 && startIndex == s.length()){
            resultList.add(String.join(".", path)); // 这个join函数用时2ms，手动StringBuilder的话就是1ms
            return;
        }
        for(int i = startIndex; i < s.length() && i < startIndex + 3; i++){
            String sub = s.substring(startIndex, i + 1);
            if(Integer.parseInt(sub) <= 255){ // 这个验证阶段真的是妙极了！直接在循环中验证，而且很简洁
                if(sub.length() > 1 && s.charAt(startIndex) == '0'){
                    return;
                }
                path.add(sub);
                backtrack(s, i + 1);
                path.remove(path.size() - 1);
            }else{
                return;
            }
        }
    }
    //=============================================================

    /**
     * 左闭右开区间
     */
    public boolean isValid(String s, int start, int end) {
        if (s.length() > 1) {
            if (s.length() > 3)
                return false;
            if (s.charAt(start) == '0')
                return false;
        }
        StringBuffer stringBuffer = new StringBuffer("");
        for (; start < end; start++) {
            stringBuffer.append(s.charAt(start));
        }
        return Integer.parseInt(stringBuffer.toString()) <= 255;
    }
}
