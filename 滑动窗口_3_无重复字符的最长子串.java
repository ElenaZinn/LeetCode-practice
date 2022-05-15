//https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
/**
example: s = "abcabcbb"
right = 0, charFound = {a:1}, res = 1, elements in window: [a]
right = 1, charFound = {a:1,b:1}, res = 2, [ab]
right = 2,  charFound = {a:1,b:1,c :1}, res = 3, [abc]
right = 3,  charFound = {a:2,b:1,c :1}, [abca]
  left = 0, s[left] = s[0] = a,charFound = {a:1,b:1,c :1} res = 3, [bca]
right = 4,  charFound = {a:1,b:2,c :1}, [bcab]
  left = 1, s[left] = s[1] = b,charFound = {a:1,b:1,c :1} res = 3, [cab]
right = 5,  charFound = {a:1,b:1,c :2}, [cabc]
  left = 2, s[left] = s[2]= c,charFound = {a:1,b:1,c :1} res = 3, [abc]
right = 6,  charFound = {a:1,b:2,c :1}, [abcb]
  left = 3, s[left] = s[3] = a,charFound = {a:0,b:2,c :1}, [bcb]
  left = 4, s[left] = s[4]= b,charFound = {a:0,b:1,c :1}, [cb] 缩小窗口至不再有重复字母
  res = 3
right = 7,  charFound = {a:0,b:2,c :1}, [cbb]
  left = 5, s[left] = s[5]= c,charFound = {a:0,b:2,c :0} res = 3, [bb]
  left = 6, s[left] = s[6] = b,charFound = {a:0,b:1,c :0} res = 3,[b]
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