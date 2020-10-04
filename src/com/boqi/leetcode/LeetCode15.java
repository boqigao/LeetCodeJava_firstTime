package com.boqi.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三数之和
 */
public class LeetCode15 {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length == 0) {
            return result;
        }

        Arrays.sort(nums);

        /**
         * 先选中一个i，
         * 然后在剩下的数字里面找-i
         * j k 分别代表两边
         * 如果比-i小，就升级j
         * 如果比-i大，就缩小k
         */
        for (int i = 0; i < nums.length; i++) {
            //  i也需要去重，continue就是跳过循环
            if(i > 0 && nums[i] == nums[i-1]) continue;
            int target = -nums[i];
            int j = i + 1; // left pointer
            int k = nums.length - 1; // right pointer
            while (j < k) { //不能等于，因为不能复用一个数当做两个数用
                if(nums[j] + nums[k] == target) {
                    List<Integer> curr = new ArrayList<>();
                    curr.add(nums[i]);
                    curr.add(nums[j]);
                    curr.add(nums[k]);
                    j++;
                    k--;
                    while (j < nums.length && nums[j] == nums[j-1]) j++;
                    while (k > j && nums[k] == nums[k+1]) k--;
                } else if (nums[j] + nums[k] > target) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return result;
    }
}
