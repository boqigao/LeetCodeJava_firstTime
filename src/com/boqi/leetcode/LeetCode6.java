package com.boqi.leetcode;

public class LeetCode6 {
    public static void main(String[] args) {

    }
    public String convert(String s, int numRows) {
        if(s == null | s.length()== 0) return s;
        // 生成n行的array
        StringBuilder[] array = new StringBuilder[numRows];
        for (int i = 0; i < array.length; i++) {
            array[i] = new StringBuilder();
        }

        // 设置一个填格子的方向，往下走是+1，往上走是-1
        int dir = 1;
        // index：第几行，初始是第0行
        int index = 0;
        for(char c : s.toCharArray()) {
            // 把字符添加到相应行中
            array[index].append(c);
            // index + dir 意味着：
            // 如果dir为正，那就是往下走
            // 如果dir为负，那就是往上走
            index += dir;

            // 如果走到了最顶上 (index == 0)
            // 或者走到了最下面 (index == 行数-1)
            // 就需要调转dir的方向
            if(index == 0 || index == numRows - 1) {
                dir = -dir;
            }
        }
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < array.length; i++) {
            result.append(array[i]);
        }
        return result.toString();
    }
}
