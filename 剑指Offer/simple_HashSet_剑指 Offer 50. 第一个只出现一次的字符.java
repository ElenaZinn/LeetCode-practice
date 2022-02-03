//https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/
class Solution {
    public char firstUniqChar(String s) {
        if(s.isEmpty()) {
            return ' ';
        }
        HashSet<Character> set = new HashSet<>();
        for (char letter : s.toCharArray()) {
            if(set.contains(letter)) {
                //重复的字符删掉
                s =s.replace(String.valueOf(letter), "");
            }else{
                set.add(letter);
            }
        }
        return s.isEmpty() ? ' ':s.charAt(0);
    }
}