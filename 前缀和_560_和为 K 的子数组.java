//题目地址：https://leetcode-cn.com/problems/subarray-sum-equals-k/
class Solution {
  
    /**
    * 双重遍历，比较浪费时间
    int[] preSum;
    public int subarraySum(int[] nums, int k) {
        int res = 0;
        func(nums);
        for (int i=0; i<nums.length;i++){
            for (int j=nums.length; j>i; j-- ) {
                if (preSum[j] - preSum[i]==k) {
                    res ++;
                }
            }
        }
        return res;

    }
    public void func (int[] nums){
        preSum = new int[nums.length +1 ];
        preSum[0] = 0;
        for ( int i=1;i<preSum.length ; i++) {
            preSum[i] = preSum[i-1] + nums[i-1];
        }
    }
    */
    public int subarraySum(int[] nums, int k) {
        int sum_total = 0,sum_sub ,res = 0;
        HashMap<Integer, Integer>  preSum = new HashMap<>();
        preSum.put(0,1);
        for (int i=0; i<nums.length; i++) {
            sum_total += nums[i];
            sum_sub = sum_total -k;
            if (preSum.containsKey(sum_sub)){
                res += preSum.get(sum_sub);
            }

            preSum.put(sum_total,preSum.getOrDefault(sum_total,0) +1);
        }
        return res;
    }
}
