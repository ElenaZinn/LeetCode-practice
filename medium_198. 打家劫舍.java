/**动态规划
对于某个位置的值来说，后两个的状态只有抢和不抢【】【】【抢】【不抢】【抢】【】【】
 */
/**
need example
 */
class Solution {
    private int[] saveStatus;
    public int rob(int[] nums) {
        saveStatus = new int[nums.length];
        //用-1填充整个数组
        Arrays.fill(saveStatus,-1);
        return statusChange(nums,0);
    }
    public int statusChange(int[] nums, int start) {
        int res = 0;
        if(start >=nums.length) {
            return 0;
        }
        //避免重复计算？why？？
        if(saveStatus[start]!=-1) {
            return saveStatus[start];
        }

        res = Math.max(statusChange(nums,start +1), statusChange(nums,start+2) + nums[start]);
        saveStatus[start] = res;
        return res;
    }
}