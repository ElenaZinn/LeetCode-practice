//https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/
//思路：i从右向左查找偶数，j从左向右查找奇数
//x&1 位运算 等价于 x%2 取余运算，即皆可用于判断数字奇偶性。
class Solution {
    public int[] exchange(int[] nums) {
        int i=0, j=nums.length-1;
        while(i <j) {
            while(i<j && nums[i]%2!=0) {
                i++;
            }
            while(i<j && nums[j]%2==0) {
                j--;
            }
            int tmp = nums[i];
            nums[i] =nums[j];
            nums[j]=tmp;
        }
        return nums;
    }
}