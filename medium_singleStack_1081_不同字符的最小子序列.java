//https://leetcode-cn.com/problems/smallest-subsequence-of-distinct-characters/
/**example
s = "cbacdcbc"
             a  b   c  d
count=[0...0,1, 2,  4, 1, 0...0]
             97,98,99,100
letter = c, count[99='c'] =3,                                                          uniqueCharacter = [c], isStack[99 ='c'] = true;
letter = b, count[98='b'] =1, in while, uniqueCharacter = [], isStack[99 ='c'] = false,uniqueCharacter = [b],isStack[99 ='b'] = true;
letter = a, count[97='a'] =0, in while, uniqueCharacter = [], isStack[98 ='b'] = false,uniqueCharacter = [a],isStack[97 ='a'] = true;
letter = c, count[99='c'] =2,                                                          uniqueCharacter = [a,c], isStack[99 ='c'] = true;
letter = d, count[100='d'] =0,                                                         uniqueCharacter = [a,c,d], isStack[100 ='d'] = true;
letter = c, count[99='c'] =1, c has in stack, continue
letter = b, count[98='b'] =0, in while, counrt[栈顶d] =0, break,                        uniqueCharacter = [a,c,d,b],isStack[99 ='b'] = true;                            
letter = c, count[99='c'] =0, c has in stack, continue          
 */
class Solution {
    public String smallestSubsequence(String s) {
        Stack<Character> uniqueCharacter = new Stack<>();
        //标记字符是否出现在栈中
        boolean[] inStack = new boolean[128];
        //ASCII码，含扩展最多有256个字符
        int[] count = new int[128];
        //给单个字母计数
        for(int i=0;i<s.length();i++){
            count[s.charAt(i)]++;
        }       
        for(int i=0;i<128;i++){
           if(count[i] !=0) {
               System.out.println(i + " = " + count[i]);
           }
        } 
        for(char letter :s.toCharArray()) {
            //每遍历一个字符，对应计数减一
             count[letter]--;
            //若字符在栈中，直接跳过
            if(inStack[letter]) continue;
        
            while(!uniqueCharacter.isEmpty() && letter < uniqueCharacter.peek()) {
                //若弹出后，栈中不存在该字符了，应保留这个字符
                if(count[uniqueCharacter.peek()]==0) {
                    break;
                }
                //若之后还有，弹出栈顶并标记为不在栈中
                inStack[uniqueCharacter.peek()]=false;
                uniqueCharacter.pop();
            }
            //不在栈中，插入栈顶并标记为存在
            uniqueCharacter.push(letter);
            inStack[letter]=true;
        }
        //将栈中元素添加到StringBuilder中
        StringBuilder res = new StringBuilder();
        while(!uniqueCharacter.isEmpty()){
            res.append(uniqueCharacter.peek());
            uniqueCharacter.pop();
        }
        //栈是倒序，反转一下
        return res.reverse().toString();
        
    }
}