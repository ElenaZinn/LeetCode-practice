// https://leetcode-cn.com/problems/valid-parentheses/
class Solution {
    public boolean isValid(String s) {
        Stack <Character>  brackets = new Stack<>();
        for(int i=0;i<s.length();i++) {
            Character bracket = s.charAt(i);
            if(bracket =='{'||bracket =='(' || bracket =='[') {
                //左括号压入栈中
                brackets.push(bracket);
            }else if (!brackets.isEmpty() && leftOf(bracket) == brackets.peek()) {
                //遇到右括号看与栈顶元素是否匹配
                brackets.pop();
            }else{
                //符号不匹配
                return false;
            }
        }
        //看左右括号个数是否匹配
        return brackets.isEmpty();
    }
    public char leftOf(Character bracket) {
        if(bracket =='}') return '{';
        if(bracket == ']') return '[';
        return '(';
        
    }
}