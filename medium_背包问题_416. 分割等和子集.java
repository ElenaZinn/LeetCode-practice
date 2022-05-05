//https://leetcode-cn.com/problems/partition-equal-subset-sum/
/**
*dp[i][j]: i是背包内元素的个数,j表示背包容量，如果 dp[4][9] = true，其含义为：对于容量为 9 的背包，若只是用前 4 个物品，可以有一种方法把背包恰好装满
base case 
    背包没有空间，相当于装满了  dp[..][0] = true 
    没有物品选择，没法装       dp[0][..] = false
 */
class Solution {
    public boolean canPartition(int[] nums) {
        //求和
        int sum = getSum(nums);
        //sum 为奇数，不可能分成两部分
        if(sum %2!=0) return false;
        int half_sum = sum/2;
        boolean[][] dp = new boolean[nums.length+1][half_sum+1];
        //init dp array, base : 背包没有空间，相当于装满了
        for(int i=0;i<= nums.length;i++) {
            dp[i][0] = true;
        }
        for(int i=1;i<=nums.length;i++) { //!!!!<=
            for(int j=1;j<=half_sum;j++) {//j表示背包容量.  //!!!!<=
                if(j-nums[i-1] <0) { //背包剩余容量 = 容量j-上一个物品大小 ， 容量不足
                    dp[i][j] = dp[i - 1][j];
                }else{
                    // 装入或不装入背包
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[nums.length][half_sum];
    }
    public int getSum(int[] nums) {
        int sum = 0;
        for(int n: nums) {
            sum +=n;
        }
        return sum;
    }
}