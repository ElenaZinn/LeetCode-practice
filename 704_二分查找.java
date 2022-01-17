// https://leetcode-cn.com/problems/binary-search/
class Solution {
    public int search(int[] nums, int target) {
        int left  = 0, right = nums.length -1;
        while (left <= right){ //是<=, 因为right = nums.length -1而不是right = nums.length
            // int mid = (left+ right)/2;
            int mid = left + (right -left)/2; //有效防止right,left 太大溢出
            if (target == nums[mid]){
                return mid;
            }else if(target < nums[mid]){
                right  = mid-1;
            }else{
                left = mid +1;
            }
        }
        return -1;
    }
}