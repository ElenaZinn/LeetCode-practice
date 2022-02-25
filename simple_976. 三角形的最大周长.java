//https://leetcode-cn.com/problems/largest-perimeter-triangle/
/**example
nums = [6,3,2,3]
after sort, nums = [2,3,3,6]
i = 3 不满足nums[3] < nums[3] + nums[1] i--=2
i = 2, 满足nums[2] < nums[1] + nums[0] i--=1  break 
return 8
 */
 /**
 思考：三角形必备条件A<B+C,若要求得最大周长，需要B+C尽可能大。
 若不存在A使得A<B+C，则对A来说：不存在以A为最小边的三角形且周长最大
  */
class Solution {
    public int largestPerimeter(int[] nums) {
        //升序
        Arrays.sort(nums);
        //倒序查找
        for (int i=nums.length-1;i>1;i--) {
            if(nums[i] < nums[i-1] + nums[i-2]) {
                return nums[i] + nums[i-1] + nums[i-2];
            }
        }
        return 0;
    }
}