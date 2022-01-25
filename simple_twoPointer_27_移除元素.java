//https://leetcode-cn.com/problems/remove-element/submissions/
//similar with https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
class Solution {
    public int removeElement(int[] nums, int val) {
        int slow = 0, fast = 0;
        int length = nums.length;
        while(fast<length) {
            if(nums[fast]!=val){
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
}