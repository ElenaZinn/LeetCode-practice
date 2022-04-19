/**
link: https://leetcode-cn.com/problems/unique-morse-code-words/
 */
class Solution {
    public int uniqueMorseRepresentations(String[] words) {

        //26 个英文字母的摩尔斯密码表
        String[] nums = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        HashSet<String> encode = new HashSet<>();
        for(String word: words) {
            StringBuilder sb = new StringBuilder(); //用来拼接
            for (char c : word.toCharArray()) {
                //字母ASCII码差值= index
                sb.append(nums[c-'a']);
            }
            encode.add(sb.toString());
        }
        return encode.size();
    }
}