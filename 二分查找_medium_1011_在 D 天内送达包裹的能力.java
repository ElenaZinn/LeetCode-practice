//https://leetcode-cn.com/problems/capacity-to-ship-packages-within-d-days/
//hint: 二分查找
/**
转化成问题：x = day, f(X) = 运载能力下需要的运输天数, target = days
find f(X) <= target 的最小x
 */
 /**
 example
weights = [3,2,2,4,1,4], days = 3
left = 4, right = 17, mid = 10
    D1 = 3,2,2
    D2 = 4,1,4, day = 2<days, 缩小区间看是否有更小的值，缩小区间值[4,10)
left = 4, right = 10, mid = 7
    D1 = 3,2,2
    D2 = 4,1
    D3 = 4, day = 3 =days, 正好送完，缩小区间看是否有更小的值，缩小区间值[4,7)
left = 4, right = 7,mid = 5
    D1 = 3,2
    D2 = 2
    D3 = 4,1
    D4 = 4, day = 4>days, 送不完，得提高最小载荷，缩小区间到[6,7)
left = 6, right = 7, mid = 6
    D1 = 3,2
    D2 = 2,4
    D3 = 1,4, day = 3=days, right = mid = 6<left, 跳出循环
return left = 6
  */
class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left = 1,mid = 0 ;
        // int right = 500+1; 区间数值还可以缩小，right取weights的和，left取weight中的最大值，因为至少要能运走一批货物
       int right = 1;
        for (int weight : weights) {
            left = Math.max(left, weight);
            right += weight;
        }
        while (left < right){
            mid = left + (right - left)/2;
            int day = daysWithGivenCapacity(weights,mid);
            System.out.println(" left = " + left + " right = " + right +  " mid = " + mid + " day = " + day );
            if(day <days) { //可以送完货，缩小区间需要验证是否还有满足条件的最小值
                right = mid;
            }else if(day > days) {//送不完货，提高最低载重
                left = mid +1;
            }else if(day ==days) {//可以送完货，缩小区间需要验证是否还有满足条件的最小值，
                right = mid;
            }
            //day<=days 可以合并
        }
        return left;
    }
    public int daysWithGivenCapacity(int[] weights, int capacity){
        int days = 0, sum = 0;
        for (int i=0;i<weights.length;i++){
            sum += weights[i];
            if (sum > capacity){
                sum =0;
                days++;
                i--; //超载了，进度回退
                continue;
            }
            //最后一天可能不满足sum > capacity，从而少算了一天
            if (i==weights.length-1 && sum <=capacity) {
                days++;
            }
        }
        return days;
    }
    
   
}