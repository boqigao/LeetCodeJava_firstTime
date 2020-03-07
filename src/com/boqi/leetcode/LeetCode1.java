package com.boqi.leetcode;

import java.util.Arrays;

public class LeetCode1 {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(nums, target)));

    }

    public static int[] twoSum(int[] nums, int target) {
        int temp = 0;
        for(int i = 0; i < nums.length; i++){
            temp = nums[i];
            for (int j = i+1; j < nums.length; j++){
                if (target == (temp + nums[j])){
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{0};
    }
}
