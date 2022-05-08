//https://leetcode-cn.com/problems/buddy-strings/
/**
buddy-string: length of two string are same,  number of character are same
 */
class Solution {
    public boolean buddyStrings(String s, String goal) {
        //length of two string are not same,
        if(s.length()!=goal.length()) return false;
        //store number of characters in string
        int[] num_s = new int[26], num_goal = new int[26];
        //number of different characters
        int count = 0;
        for(int i=0;i<s.length();i++) {
            int x = s.charAt(i) - 'a';
            int y = goal.charAt(i)- 'a';
            num_s[x]  ++;
            num_goal[y] ++;
            if(x!=y) {
                count++;
            }
        }
        /**         当「s 与 goal不同的字符数量为 2（能够相互交换）」或「s 与 goal 不同的字符数量为 0，但同时 s 中有出现数量超过 2 的字符（能够相互交换）」时，两者必然为亲密字符。
        */
        boolean res = false;
        for(int i=0;i<26;i++) {
            if(num_s[i]!=num_goal[i]) return false; // number of character are not same
            if(num_s[i]>1){
                res = true;
            }
        }
        //能走到这一步说明s和goal的长度相同，字母相同
        //只有两种能返回true：
        // 第一种：s和goal有两个位置不同的
        // 第二种：没有位置不同的但是需要有字母的数量大于1 例如："ab" "ab" return false  "abb" "abb" returen true
        return count==2 || (count==0 && res == true);

    }
}