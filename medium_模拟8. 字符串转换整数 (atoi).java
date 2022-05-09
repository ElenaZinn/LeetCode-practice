//https://leetcode.cn/problems/string-to-integer-atoi/
class Solution {
    public int myAtoi(String s) {
        char[] chs = s.toCharArray();
        int i=0;
        //1. 去掉空格
        while(i<chs.length && chs[i] == ' ') {
            i++;
        }
        //可能出现遍历结束的情况
        if(i==chs.length) {
            return 0;
        }
        //2. 遍历符号
        char first = chs[i];
        int sign = 1; //positive 
        if(first == '+') {
            i++;
        }else if(first =='-') {
            sign = -1; //negative
            i++;
        }
        //可能出现遍历结束的情况
        if(i==chs.length) {
            return 0;
        }
        int res = 0;
        //3. 遍历内容
        while(i<chs.length) {
            // 先判断不合法的情况 如"+-42"
            if (chs[i] > '9' || chs[i] < '0') {
                break;
            }
            // 题目中说：环境只能存储 32 位大小的有符号整数，因此，需要提前判：断乘以 10 以后是否越界
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && (chs[i] - '0') > Integer.MAX_VALUE % 10)) {
                return sign>0?Integer.MAX_VALUE:Integer.MIN_VALUE;
            }
            // 合法的情况下，才考虑转换
            res = res * 10 +chs[i] - '0';
            i++;
        }
       
        return sign>0?res:sign*res;
    }
}