//https://leetcode-cn.com/problems/minimum-insertions-to-balance-a-parentheses-string/submissions/
// similar as 921 https://leetcode-cn.com/problems/minimum-add-to-make-parentheses-valid/submissions/
/**example
s = "))())(", needForLeft =0, needForRight=0;
')'  needForRight =-1, needForLeft =1, needForRight=1;
')'  needForRight =0;
'(', needForRight = 2;
')'  needForRight =1;
')'  needForRight =0;
'(', needForRight = 2;
res = needForLeft + needForRight = 3;
 */
class Solution {
    public int minInsertions(String s) {
        int needForLeft = 0, needForRight =0;
        for (int i=0;i<s.length();i++) {
            char bracket = s.charAt(i);
            if (bracket =='(') {
                needForRight +=2;
                //右括号是奇数个，只需要添加一个左括号
                if(needForRight %2 ==1) {
                    needForLeft++;
                    needForRight--;
                }
            }

            if(bracket ==')') {
                needForRight--;
                if(needForRight==-1){
                    //少一个右括号
                    needForLeft++;
                    needForRight =1;
                }
            }
        }
        return needForRight + needForLeft;
    }
}