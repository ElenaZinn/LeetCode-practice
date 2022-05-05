//https://leetcode-cn.com/problems/add-strings/
/**
可以参考二进制求和 https://leetcode-cn.com/problems/add-binary/
   1 2 3
     1 1
       4
     3
   1
 */
class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder res = new StringBuilder();
        int m=num1.length(),n= num2.length();
        int carry = 0;
        for(int i=m-1,j=n-1; i>=0 || j>=0 || carry>0;i--,j--) {
            int add1  = i>=0? num1.charAt(i)-'0' :0;
            int add2  = j>=0? num2.charAt(j)-'0' :0;
            int sum = add1+add2+carry;
            carry = sum >=10 ? sum/10 :0;
            int remain = sum >=10? sum%10 :sum;
            res.append(remain);
        }
        if(carry>0) {
            res.append(carry);
        }
        return res.reverse().toString();
   }
}