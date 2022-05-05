//https://leetcode-cn.com/problems/3sum/
class Solution {
    /** 暴力解法 超时
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();
    int sum = 0;
    // boolean[] used;
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        backTrace(nums,0);
        return res;
    }
    public void backTrace(int[] nums, int start) {
        if(path.size()==3 && sum==0) {
            res.add(new LinkedList<>(path));
            return;
        }
        for(int i=start;i<nums.length;i++) {
            if (i > start && nums[i] == nums[i - 1]) { //去重
                continue;
            }
            path.add(nums[i]);
            sum += nums[i];
            backTrace(nums,i+1);
            path.removeLast();
            sum -= nums[i]; 
        }
        
    }
    */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length <= 2) return ans;

        Arrays.sort(nums); // O(nlogn)
        for(int i=0;i<nums.length;i++) {
            if(nums[0]>0) { //第一个数大于0，三数之和必然都大于0
                break;
            }
            if(i >0 && nums[i] == nums[i-1]) {//去重
                continue;
            }
            int target = -nums[i];  //target=剩余两个数的和
            int left = i+1, right = nums.length-1;
            while(left<right) {
                if(nums[left] + nums[right]  == target) {
                    ans.add(new ArrayList<>(Arrays.asList(nums[i], nums[left],nums[right])));
                    left++;
                    right--;
                    while(left <right && nums[left]==nums[left-1] ) left++; //去重
                    while(left <right && nums[right]==nums[right +1] ) right--; //去重
                }else if(nums[left] + nums[right]  < target) {//like binary search
                    left ++;
                }else { //like binary search
                    right--;
                }
            }
        }
        return ans;
    }
}