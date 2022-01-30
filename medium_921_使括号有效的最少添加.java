//https://leetcode-cn.com/problems/minimum-add-to-make-parentheses-valid/submissions/
/**example
s = "()))((", needForLeft = 0, needForRight = 0,
'(', needForRight  = 1;
')', needForRight  = 0;
')'  needForRight  = -1<0, needForRight  = 0,needForLeft = 1;
')'  needForRight  = -1<0, needForRight  = 0,needForLeft = 2;
'(', needForRight  = 1;
'(', needForRight  = 2;
res = needForRight + needForLeft =4;
 */
class Solution {
    public int minAddToMakeValid(String s) {
        int need_for_left_bracket = 0, need_for_right_bracket =0;
        for (int i=0; i<s.length(); i++) {
            char bracket = s.charAt(i);
            if(bracket =='(') {
                //若输入左括号，对右括号需求+1
                need_for_right_bracket++;
            }
            //若输入右括号，对右括号需求-1
            if(bracket ==')') {
                need_for_right_bracket--;

                //右括号太多,需要左括号
                if(need_for_right_bracket ==-1) {
                    need_for_right_bracket=0;
                    //需要插入一个左括号
                    need_for_left_bracket++;
                    
                }
            }
            

        }

        return need_for_right_bracket + need_for_left_bracket;
    }
}