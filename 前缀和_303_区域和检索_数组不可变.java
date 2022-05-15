//https://leetcode-cn.com/problems/range-sum-query-immutable/
class NumArray {
    
    //优化思路：使用一个数组记录前缀和，要求的部分和即两个前缀和做减法
    //nums = [0,1,2,3,4], preSum = [0,0,1,3,6,10], sumRange(1,3) = preSum[5]- preSum[1]
    //preSum[0] = 0 便于计算
    private int[] preSum;
    public NumArray(int[] nums) {
        preSum = new int[nums.length +1 ];
        for (int i=1; i < preSum.length ;i++){
            preSum[i]  = preSum[i-1] + nums[i-1];
        }
    }

    public int sumRange(int left, int right) {
        return preSum[right +1] - preSum[left];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
