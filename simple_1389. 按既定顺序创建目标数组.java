//https://leetcode-cn.com/problems/create-target-array-in-the-given-order/
/**
插入数组
 */
class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        List<Integer> arr = new ArrayList<>();
        for(int i=0;i<nums.length;i++) {
            arr.add(index[i],nums[i]);
        }
        int[] res = new int[arr.size()];
        for(int j=0;j<res.length;j++) {
            res[j] = arr.get(j);
        }
        return res;
    }
}