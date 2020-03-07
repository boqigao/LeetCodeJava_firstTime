package com.boqi.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * LeetCode第三题:检测不有重复字符的最长子字符串的长度
 * 思路：Sliding window的做法
 * @author Boqi Gao
 */
public class LeetCode3 {
    public static void main(String[] args) {
        String test = "aafdddasfijqda";
        System.out.println(lengthOfLongestSubstring(test));
    }

    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();

        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0; //i是最长子字符串的投一位，j是最长子字符串末尾的后一位
        while (i<n && j <n){
            // 尝试去扩展【i，j】的长度，j-i就是最长子字符串的长度
            if(!set.contains(s.charAt(j))){ //如果这个set中不包含第j位的字符，那就可以继续扩展
                set.add(s.charAt(j));//此时将【原末尾的后一位加入】
                j+=1;//j变成【新后尾的后一位】
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i));//如果包括了，那说明第j位和第i位重复了，所以把第i位移除掉
                i+=1;
            }
        }
        return ans;
    }
}
