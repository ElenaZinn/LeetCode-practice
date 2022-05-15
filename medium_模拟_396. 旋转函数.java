//https://leetcode-cn.com/problems/rotate-function/
/**
（x+m）%n  即可得到正确的位置
 */
class Solution {
    /** 有例子超时了
    public int maxRotateFunction(int[] nums) {
        int i=0;
        int n = nums.length;
        int max = 0;
        //需要循环n次，求得n个F()的值
        while(i<n) {
            //新的index = （x+i）%n,f(i) = index * nums[i];
            int sum = 0;
            for(int j=0;j<n;j++) {
                sum += ((j+i)%n)*nums[j];
            }
            //求最大值
            max = Math.max(sum,max);
            i++;
        }
        return max;
    }
    */
    /** 每次移动都是加上了n倍的首项，减去数组sum
    */
    public int maxRotateFunction(int[] nums) {
        int sum=0,rotateSum=0;
        int n=nums.length;
        for(int i=0;i<n;i++) {
            sum += nums[i];
            rotateSum += i*nums[i];
        }
        int ans=rotateSum;
        for(int i=0;i<n-1;i++){
            //I don't understand here
           // System.out.println("rotateSum = " + rotateSum + " nums[i]= " +nums[i] + " sum = " + sum );
            rotateSum+=n*nums[i]-sum;
            //System.out.println("rotateSum = " + rotateSum);
            ans=Math.max(ans,rotateSum);
        }
        return ans;
    }
}