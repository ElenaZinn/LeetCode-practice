//https://leetcode-cn.com/problems/4sum/
/**

 */
class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>>  fourSum (int[] nums, int target) {
        Arrays.sort(nums);
        
        if(nums.length <4) { //长度不满足四个数相加
            return ans;
        }
        
        for(int i=0;i<nums.length-3;i++) { //时间复杂度为O（n的三次方）
            if(i>0 && nums[i] ==nums[i-1]) { //去重
                continue;
            }
            int tar = target-nums[i];
            //需要找到和为tar的三个数的序列
            threeSum(nums,tar,nums[i],i+1);
        }
        return ans;
    }
    public void threeSum(int[] nums, int tar, int start, int given) {
        
        for(int i=given; i<nums.length-2;i++) {
            if(i>given && nums[i] ==nums[i-1]) { //去重. 注意i的条件
                continue;
            }
            
            int target = tar -nums[i];
            int left =i+1,right = nums.length-1;
            while(left<right) {
                if(nums[left] + nums[right]==target) {
                    ans.add(new ArrayList<>(Arrays.asList(start,nums[i],nums[left],nums[right])));
                    left++;
                    right--;
                    while(left<right && nums[left]==nums[left-1]) left++;//去重
                    while(left<right && nums[right]==nums[right+1]) right--;//去重
                }else if(nums[left] + nums[right]  < target) {//like binary search
                    left ++;
                }else { //like binary search
                    right--;
                }
            }
        }
    }
}