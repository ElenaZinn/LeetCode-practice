//https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof/
//斐波那契数列
class Solution {
    public int numWays(int n) {
        int base1=1,base2=1;
        int sum = 0;
        for (int i=0;i<n;i++){
           sum = (base1 + base2)%1000000007;
           base1 = base2;
           base2 = sum;
        }
        return base1;
    }
}