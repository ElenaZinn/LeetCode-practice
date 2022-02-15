//https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof/

/** 
递归调用，当n>=某个值会超出时间限制
class Solution {
    public int fib(int n) {
        //base case
        if(n<=1){
            return n;
        }
        return fib(n-1) + fib(n-2);
    }
}
*/
class Solution {
    public int fib(int n) {
       //动态规划，使用转移方程f(n+1)=f(n)+f(n−1);
       //空间复杂度优化:只对相邻的三个数sum,a,b操作，使用sum记住前两数之和
       //循环求余法: sum = (a + b) % 1000000007sum=(a+b)⊙1000000007 ，此操作与最终返回前取余等价
       int sum = 0;
       int base1 = 0, base2 = 1;
       for(int i=0;i<n;i++) {
           sum = (base1 + base2) % 1000000007;
           base1 = base2;
           base2 = sum;
       } 
       return base1;
    }
}