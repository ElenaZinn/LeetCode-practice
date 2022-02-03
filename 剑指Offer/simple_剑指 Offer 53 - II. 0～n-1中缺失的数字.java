//https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof/submissions/
/**

class Solution {
    public int missingNumber(int[] nums) {
        int i=0;
        for(i=0;i<nums.length;i++) {
            if(nums[i] != i) {
                return i;
            }
        }
        return i;
    }
}
*/
/**
优化：使用二分查找
 */
 class Solution {
    public int missingNumber(int[] nums) {
        int left = 0, right = nums.length-1;
        while(left <=right) {
            //求中点，防止溢出
            int mid = left +(right-left)/2;
            //若nums[mid]==mid，缺少的元素一定在右半区间
            if(nums[mid]==mid) {
                left = mid+1;
            }else{
            //若nums[mid]!=mid，缺少的元素一定在左半区间
                right = mid-1;
            }

        }
        return left;
    }
}