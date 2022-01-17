//https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
/**
example: s = "abcabcbb"
right = 0, charFound = {a:1}, res = 1
right = 1, charFound = {a:1,b:1}, res = 2
right = 2,  charFound = {a:1,b:1,c :1}, res = 3
right = 3,  charFound = {a:2,b:1,c :1}
    s.charAt(left) = s.charAt(0) = a,charFound = {a:1,b:1,c :1} res = 3
right = 4,  charFound = {a:1,b:2,c :1}
     s.charAt(left) = s.charAt(1) = b,charFound = {a:1,b:1,c :1} res = 3
right = 5,  charFound = {a:1,b:1,c :2}
    s.charAt(left) = s.charAt(2) = c,charFound = {a:1,b:1,c :1} res = 3
right = 6,  charFound = {a:1,b:2,c :1}
    s.charAt(left) = s.charAt(3) = a,charFound = {a:0,b:2,c :1}
    s.charAt(left) = s.charAt(4) = b,charFound = {a:0,b:1,c :1}
    res = 3
right = 7,  charFound = {a:0,b:2,c :1}
    s.charAt(left) = s.charAt(5) = c,charFound = {a:0,b:1,c :1} res = 3
 */
class Solution {
    //hint：sliding window
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> charFound = new HashMap<>();
        int right = 0, left = 0;
        int res = 0;
        while (right <s.length() ) {
            char c = s.charAt(right++);
            charFound.put(c,charFound.getOrDefault(c,0) +1 );
            System.out.println("c = " + c + " charFound.get(c) = " + charFound.get(c));
            while (charFound.get(c)>1) {
                //收缩完可以保证没有重复元素
                char d = s.charAt(left ++);
                charFound.put(d,charFound.getOrDefault(d,0) - 1 );
                System.out.println("d = " + d + " charFound.get(d) = " + charFound.get(d));
            }
            res = Math.max(res, right-left);
            System.out.println("res = " + res);
        }
        return res;
    }
}