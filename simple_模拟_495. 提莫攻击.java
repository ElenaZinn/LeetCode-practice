//https://leetcode-cn.com/problems/teemo-attacking/
/**
有点类似餐厅排队
攻击重合，取最长的duration = 上次结束的位置  + 两次duration结束位置之差
不重合，直接加上duration
 */
class Solution {
    
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int ans = 0;
        int last =-1; //记录上一次攻击的结束点
        for(int i=0;i<timeSeries.length;i++) {
            int expires = timeSeries[i] + duration -1 ;
            /** 可以用三元组表示
            if(timeSeries[i] > last) { //不重合
                ans += duration;
            }else { //重合
                ans += expires-last;
            }
            */
            ans += timeSeries[i] > last? duration : expires-last;
            last = expires;
        }
        return ans;
    }
}