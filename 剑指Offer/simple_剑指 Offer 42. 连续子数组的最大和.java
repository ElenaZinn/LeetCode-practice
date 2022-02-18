//https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof/
/**
    当前累加数<0,前面的抛弃，从下一个开始计算
    当前累加数>0,
            当前累加<最大，最大=最大；
                当前累加>最大，最大= 累加
    加入下一个数，更新最大和累加
 */
 /**example
 nums = [-2,1,-3,4,-1,2,1,-5,4], len = 9, curSum = -2, maxSum = -2
i = 1,  curSum =-2<0
        curSum = 1, maxSum = curSum = 1
i = 2,  curSum =1>0
        curSum = 1-3 = -2;
i = 3,  curSum =-2<0
        curSum = 4 , maxSum = curSum = 4
i = 4,  curSum = 4>0
        curSum = 4-1 =3 
i = 5,  curSum = 3>0 
        curSum = 3+2 =5,  maxSum = curSum = 5
i = 6,  curSum = 5>0
        curSum = 5 + 1=6,  maxSum = curSum = 6
i = 7,  curSum = 6>0
        curSum = 6-5=1
i = 8, curSum = 1>0
        curSum =1+4 = 5
return maxSum = 6;
  */
class Solution {
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        if(len==0) {
            return 0;
        }
        int maxSum =nums[0], curSum = nums[0];
        for (int i=1;i<nums.length;i++) {
            if(curSum<0){
                curSum =  nums[i];
            }else{
                curSum += nums[i];
            }
            if(maxSum < curSum) {
                maxSum = curSum;
            }
        }
        return maxSum;
    }
}