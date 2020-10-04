package com.boqi.leetcode;

/**
 * 整数转罗马数字
 */
public class LeetCode12 {
    public static void main(String[] args) {

    }

    public String intToRoman(int num) {
        String[] one = new String[]{"", "I", "II", "III", "IV", "VI",
        "VII", "VIII", "IX"};
        String[] two = new String[]{"", "X", "XX", "XXX", "XL","LX", "LXX",
        "LXXX", "XC"};
        String[] thr = new String[]{"", "C", "CC", "CCC", "CD", "D","DC",
        "DCC", "DCCC","CM"};
        String[] fou = new String[]{"", "M", "MM", "MMM"};
        return fou[num/1000] + thr[num%1000/100] + two[num%100/10] +one[num%10];
    }
}
