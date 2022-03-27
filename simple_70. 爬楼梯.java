//https://leetcode-cn.com/problems/climbing-stairs/
//1 1 2 3 5 8 (斐波那契数列)
/**
爬上 n−1 阶楼梯的方法数量。因为再爬1阶就能到第n阶
爬上 n−2 阶楼梯的方法数量，因为再爬2阶就能到第n阶
 */
class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        if(n <= 2){//当有0、1、2个台阶时，分别有0、1、2种方法
            return n;
        }
        dp[0]=1;
        dp[1]=1;
        for (int i=2;i<n+1;i++ ){//i=2时是第三个台阶，i=n-1时是第n个台阶。
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}