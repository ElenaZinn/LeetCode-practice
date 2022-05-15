// https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
<<<<<<< HEAD
/**
nums = [5,7,7,8,8,10], target = 8
left_bound:
left=0,right = 5, mid = 2, nums[2] = 7 <8, left= mid +1 = 3
Mid = 4, nums[4] = target = 8, right = mid-1<left, jump out while loop
Return left = 3

Right_bound:
left=0,right = 5, mid = 2, nums[2] = 7 <8, left= mid +1 = 3
Mid = 4, nums[4] = target = 8, left = mid +1 = 5 =right
Mid = 5, nums[5] = target = 8, left = mis +1 = 6>right, jump out while loop
Return right = 5
*/
=======

>>>>>>> 381f12f61df2f43c56c3f7d8632126f20c2e7c68
class Solution {
    public int[] searchRange(int[] nums, int target) {
       return new int[]{left_bound(nums,target),right_bound(nums,target)};
    }
    public int left_bound(int[] nums, int target) {
	//搜索区间为[left, right]
        int left = 0, right = nums.length-1;
        while(left <= right) {
            int mid = left + (right - left)/2;
            if (nums[mid]<target) {
		//搜索区间为[mid +1,right]
                left = mid +1;
            }else if(nums[mid] > target) {
		//搜索区间为[left, mid-1]
                right = mid-1;
            }else if(nums[mid] == target) {
		//使得while的退出条件是left = right +1
		//缩小右边界，将相同的数字移出边界
                right = mid -1;
            }
        }
	//因为使得while的退出条件是left = right +1，当right = length-1时（target比所有元素都大），left = length 越界，所以这里需要判断left是否越界；
        if (left >= nums.length || nums[left] !=target){
            return -1;
        }
        return left;
    }
     public int right_bound(int[] nums, int target) {
	//搜索区间为[left, right]
        int left = 0, right = nums.length-1;
        while(left <= right) {
            int mid = left + (right - left)/2;
            if (nums[mid]<target) {
		//搜索区间为[mid +1,right]
                left = mid +1;
            }else if(nums[mid] > target) {
		//搜索区间为[left, mid-1]
                right = mid-1;
            }else if(nums[mid] == target) {
		//使得while的退出条件是left = right +1
		//缩小左边界，将相同的数字移出边界
                left = mid +1;
            }
        }
	//因为使得while的退出条件是left = right +1，当left = 0 时（target比所有元素都小），right 越界，所以这里需要判断right是否越界；
         if(right <0 || nums[right] != target) {
             return -1;
        }
        return right;
    }
}