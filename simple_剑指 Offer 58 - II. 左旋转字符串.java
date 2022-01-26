//https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/

class Solution {
    public String reverseLeftWords(String s, int n) {
        /**
         法一：切片
        return s.substring(n, s.length()) + s.substring(0, n);
        */
        //法二：（列表遍历拼接)取余
        StringBuilder res = new StringBuilder();
        for(int i = n; i < n + s.length(); i++)
            res.append(s.charAt(i % s.length()));
        return res.toString();
    }
}