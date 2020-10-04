package com.boqi.leetcode;

/**
 * 盛水最多的边
 * 用双指针算法，可以证明两个短边不可能作为新的边
 */
public class LeetCode11 {
    public static void main(String[] args) {

    }

    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int ans = 0;
        while (left < right) {
            int area = Math.min(height[left], height[right]) * (right-left);
            ans = Math.max(ans, area);
            // 向内移动较短的边
            if (height[left] <= height[right]){
                left+=1;
            } else {
                right-=1;
            }
        }
        return ans;
    }
}
