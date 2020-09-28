package com.boqi.leetcode;

public class LeetCode7 {

    public static void main(String[] args) {
        System.out.println(reverse(9646));
    }
    static public int reverse(int x) {
        String xStr = x + "";
        StringBuilder sb = new StringBuilder(xStr);
        try{
        if(sb.charAt(0)=='-'){
            String tmp = sb.substring(1, sb.length());
            sb = new StringBuilder(tmp);

            sb.reverse();
            int start = 0;
            if (sb.charAt(0)=='0'){
                for (int i = 1; i < sb.length(); i++){
                    if(sb.charAt(i)!='0'){
                        start = i;
                        break;
                    }
                }
            }
            String resultStr = sb.substring(start, sb.length());
            int resultInt = Integer.parseInt(resultStr);
            resultInt = -resultInt;
            return resultInt;
        }else {
            sb = sb.reverse();
            int start = 0;
            if (sb.charAt(0)=='0'){
                for (int i = 1; i < sb.length(); i++){
                    if(sb.charAt(i)!='0'){
                        start = i;
                        break;
                    }
                }
            }

            String resultStr = sb.substring(start, sb.length());
            int resultInt = Integer.parseInt(resultStr);
            return  resultInt;
        }
    }
        catch (NumberFormatException e){
            return 0;
        }
    }

}
