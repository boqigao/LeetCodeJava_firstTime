package com.boqi.leetcode;

/**
 * LeetCode第四题
 * 有两个已经排序好的数组，现在将其融合为一个数组
 * 求这个新数组的中位数
 *
 */
public class LeetCode4 {

    public static void main(String[] args) {

        int[] x = {1,3,6,9,15};
        int[] y = {7,11,19,21,18,25};
        System.out.println(findMedianSortedArrays(x, y));
    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // if nums1 length is greater. Then switch them so that nums1 length is smaller.
        // than that of input 2.

        if(nums1.length > nums2.length){
            return findMedianSortedArrays(nums2, nums1);
        }

        int xLen = nums1.length;
        int yLen = nums2.length;

        int low = 0;
        int high = xLen;
        int middlePosition = (xLen + yLen + 1)/2;

        while (low <= high){
            //partitionX前面的部分在左半边，从partitionX开始的部分在右半边
            int partitionX = (low + high) / 2; //这里的意思是总之先从x的一半开始找
            int partitionY = middlePosition - partitionX;

            //if partitionX is 0, it means that nothing is there on the left side. Use -INF for maxLeftX
            //if partitionX is the left of the input, then there is nothing on the right side. Use +INF for minRightX

            int maxLeftX = (partitionX == 0)?Integer.MIN_VALUE : nums1[partitionX - 1];
            int minRightX = (partitionX == xLen)?Integer.MAX_VALUE:nums1[partitionX];

            int maxLeftY = (partitionY == 0)?Integer.MIN_VALUE : nums2[partitionY - 1];
            int minRightY = (partitionY == yLen)?Integer.MAX_VALUE:nums2[partitionY];

            if(maxLeftX <= minRightY && maxLeftY <= minRightX){
                //如果达到这个结果，说明我们已经找到正确结果
                if((xLen+yLen) %2 ==0){
                    //新数组长度是偶数情况
                    return (double)(Math.max(maxLeftX, maxLeftY)+Math.min(minRightX,minRightY))/2;
                }else {
                    //新数组长度是奇数情况
                    //这里比较不好理解，因为我们定义的partition是算在右边部分，而且是从x数组开始找
                    return (double)Math.max(maxLeftX, maxLeftY);
                }
            } else if (maxLeftX > minRightY){
                //如果x的左边最大比右边最小要大的话，那要把x往往左移
                high = partitionX - 1;
            } else {
                low = partitionX + 1;
            }
        }
        throw new IllegalArgumentException();
    }

}
