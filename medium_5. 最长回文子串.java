//https://leetcode-cn.com/problems/longest-palindromic-substring/
// 找到以s[i]为中心的回文串
class Solution {
    public String longestPalindrome(String s) {
        String res = "";
        for(int i=0;i<s.length();i++) {
            // 以 s[i] 为中心的最长回文子串
            String s1 = centerPalindrome(s,i,i);
            // 以 s[i] 和 s[i+1] 为中心的最长回文子串
            String s2 = centerPalindrome(s,i,i+1);
            // res = longest(res, s1, s2)
            res = res.length() > s1.length() ? res:s1;
            res = res.length() > s2.length() ? res:s2;

        }
        return res;
    }
    public String centerPalindrome(String str, int left, int right) {
        while(left >=0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
            //向两边展开
            left--;
            right ++;
        }
        return str.substring(left+1, right);
    }
}