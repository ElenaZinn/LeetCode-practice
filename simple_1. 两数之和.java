//https://leetcode-cn.com/problems/two-sum/
//reference: https://leetcode-cn.com/problems/two-sum/solution/jie-suan-fa-1-liang-shu-zhi-he-by-guanpengchn/
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> result = new HashMap<>();
        int sum = 0;
        for (int i=0;i<nums.length;i++) {
            if(result.containsKey(target-nums[i])) {
                return new int[]{result.get(target-nums[i]),i};
            }
            result.put(nums[i],i);
        }
        return new int[]{};
    }
}