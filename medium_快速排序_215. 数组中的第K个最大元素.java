//https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
//快速排序+二分查找
class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length ==0) {
            return 0;
        }
        int left = 0;
        int right = nums.length-1;
        //k个最大即排序后倒数第k个数
        int target = nums.length -k;
        while(left < right) {
            int index = partition(nums,left, right);
            if(index == target) {
                return nums[index];
            }else if(index < target) {
                left = index +1;
            }else{
                right = index-1;
            }
        }
        return nums[left];
    }
      public int partition(int[] nums, int left, int right) {
        int pivot = left;
        while(left <=right) {
            while(left <=right && nums[left] <=nums[pivot]){
                left ++;
            } 
                
            while(left <=right  && nums[right] >=nums[pivot]) {
                 right --;
            }
               
            if(left > right){ break;}
            swap (nums, left, right);
        }
        swap(nums,pivot, right);
        return right;
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}