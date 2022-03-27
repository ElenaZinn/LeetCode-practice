//link：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/solution/ 
/** 
e.g. [2][3]
[a][b][c][def]
a+d,a+e,a+f; b+d,b+e,b+f
回溯树
                ”23“
            /     |    \
            a     b     c        0层 digits.charAt(0) - '0';
            |     |     |
           /|\   /|\   /|\ 
          d e f d e f d e f      1层 digits.charAt(1) - '0';
          | | | | | | | | |
          ad ae af bd be bf cd ce cf  底层：b.length() == digits.length()
 */
class Solution {
    //需要得到数字和字母的映射 
    String[] letter_map = {
        " ","*","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"
    };
    List<String> res = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if(digits.isEmpty()){
            return res;
        }
        helper(digits,0, new StringBuilder());
        return res;
    }
    void helper(String digits, int start, StringBuilder sb) {
        //到达底层
        if(sb.length() == digits.length()) {
            res.add(sb.toString());
            return;
        }
        for(int i=start;i<digits.length();i++) {
            int level = digits.charAt(i) -'0';
            for(char c : letter_map[level].toCharArray()) {
                sb.append(c);
                //递归下一层树
                helper(digits, i+1,sb);
                //撤销选择！！！！！
                sb.deleteCharAt(sb.length()-1);
            }
        }

    }
}