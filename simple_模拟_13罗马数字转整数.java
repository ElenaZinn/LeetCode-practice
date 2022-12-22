/**
*把一个小值放在大值的左边，就是做减法，否则为加法。
https://leetcode.cn/problems/roman-to-integer/description/
 */
class Solution {
    public int romanToInt(String s) {
        char[] chars = s.toCharArray();
        int pre = getValue(chars[0]);
        int sum = 0;
        for (int i=1; i< chars.length; i ++) {
            int cur  = getValue(chars[i]);
            if (pre < cur) {
                sum -= pre;
            }else {
                sum += pre;
            }
            pre = cur;
        }
        sum += pre;
        return sum;
    }

    private int getValue(char ch) {
        switch(ch) {
           case 'I' : return 1;
           case 'V' :return 5;
           case 'X' : return 10;
           case 'L' : return 50;
           case 'C' : return 100;
           case 'D': return 500;
           case 'M': return 1000;
           default: return 10;

        }


    }
}