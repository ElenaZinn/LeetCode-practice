/**
*尽可能优先使用较大数值对应的字符，最后转换得到的罗马数字的字符个数更少
为了表示一个给定的整数 num\textit{num}num，我们寻找不超过 num\textit{num}num 的最大符号值，将 num\textit{num}num 减去该符号值，然后继续寻找不超过 num\textit{num}num 的最大符号值
 */
class Solution {
    public String intToRoman(int num) {
        int[] values={1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] rom={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

        StringBuilder sb = new StringBuilder();
        for ( int i=0;i<values.length;i++) {
            while (num >= values[i]) {
                sb.append(rom[i]);
                num -= values[i];
            }
        }
        return sb.toString();
    }
}