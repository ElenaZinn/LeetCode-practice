//https://leetcode-cn.com/problems/koko-eating-bananas/
//hint: 二分查找
/**
思路
有 x,f(x)单减函数,target = hour
若吃香蕉的速度为x根/小时，则需要f(x)小时吃完所有香蕉, 找到令f(x)<= target的最小x
 */
/**
example
piles = [3,6,7,11], H = 8
left = 1, right = 100000001, mid = 500000001,hour = 4%mid = 4 < h, 缩小区间使用左半区间domin = [1,500000001)
...
left = 1, right = 30, mid = 15, hour = size/mid = 4%15 = 4 < H, 缩小区间使用左半区间domin = [1,15)
left = 1, right = 15, mid = 8
    hour = 3%mid + 6%mid + 7%mid + 11/mid + 11%mid = 5 <H
    缩小区间使用左半区间domin = [1,8)
left = 1, right = 8, mid = 4
    hour = sumOfValue{3%4:1,6/4 :1, 6%4:1, 7/4 :1 ,7%4:1,11/4:2 ,11%4 :1}  = 8 = H
    缩小区间使用左半区间domin = [1,4)
left = 1, right = 4,mid = 2
    hour = sumOfValu{3/2 : 1, 3%2:1,6/2 :3,7/2 :3 ,7%2:1,11/2:5 ,11%2 :1}  = 15 > H
    缩小区间使用右半区间domin = [3,4)
left = 3, right = 4,mid = 3
    hour = sumOfValu{3/3 : 1, 6/3 :1,7/3 :2 ,7%3:1,11/3:3 ,11%3 :2}  = 10 > H
    区间无法再缩小，返回right
 */
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = 1000000000 + 1;   //根据题目提示设置边界
        int mid = 0;
        while (left < right) {
            mid = left +(right -left)/2;
            int hour = hourWithGivenSpeed(piles,mid);
            System.out.println("right = " + right + " left = " + left + " mid = " + mid + " hour = " + hour );
            if (hour < h) {  //可以吃得完，但是速度不是最小的
                right =mid; 
            }else if(hour>h) { //吃不完，提高速度
                left = mid + 1;
            }else if(hour==h){//正好吃完，要看速度能否再变小
                right = mid;
            }
            //hour <= mid可以合并
        }
        return right;

    }
    public int hourWithGivenSpeed(int[] piles, int speed){
        int hours = 0;
        for (int i=0;i<piles.length;i++){
            hours += piles[i]/speed; //求整除的值
            if(piles[i]%speed>0) {//余数，即没吃完的放到下一个小时吃
                hours ++;
            }
        }
        return hours;
    }
}