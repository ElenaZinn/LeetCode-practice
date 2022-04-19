//https://leetcode-cn.com/problems/jump-game/
class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int farthest=0;
        //这里是小于n-1
        for(int i=0;i<n-1;i++) {
            farthest = Math.max(farthest, nums[i] + i);
         //可能碰到了 0，卡住跳不动了
            if(farthest<=i) {
                return false;
            }
        }
        return farthest >=n-1;
        
    }
}