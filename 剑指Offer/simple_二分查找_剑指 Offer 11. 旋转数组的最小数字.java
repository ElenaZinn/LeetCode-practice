//https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/
/** 
法一：直接求最小值
class Solution {
    public int minArray(int[] numbers) {
        return min(numbers);
    }
    public int min (int[] numbers) {
        int min = numbers[0];
        for(int i=0;i<numbers.length;i++) {
            if(numbers[i]<min){
                min = numbers[i];
            }
        }
        return min;
    }
}
*/
/**
法二：二分查找
 */
 /**example
 [3,4,5, 1,  2]
        pivot
  */
 class Solution {
    public int minArray(int[] numbers) {
        int left = 0, right = numbers.length-1;
        while(left<right){
            int mid = left +(right -left)/2;
            if(numbers[mid]>numbers[right]) {
                //中间值>最右侧的值，pivot一定在右侧区间
                left = mid+1;
            }else if(numbers[mid]>numbers[right]) {
                //中间值< 最右侧的值，pivot一定在左侧区间
                right = mid;
            }else{
                //中间值 = 最右侧, 无法判断左右区间，只能缩小范围
                right--;
            }
        }
        return numbers[left];
    }
    
}