//https://leetcode-cn.com/problems/gu-piao-de-zui-da-li-run-lcof/
/**example
price =  [7,1,5,3,6,4]
min = 7, curP = 0, maxP =0;
i=1, min = 1, curP =0;
i=2,          curP =5-1=4 < maxP, maxP = 4;
i=3,          curP = 3-1 = 2;
i=4,          curP = 6-1=5 > maxP, maxP = 5;
i=5,          curP = 4-1=3;
return maxP = 5;
 */
class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length==0){
            return 0;
        }
        int minBuyingPrice = prices[0];
        int maxprofit = 0,currentprofit =0;
        for(int i=1;i<prices.length;i++) {
            //获取最小购入价格
            if(prices[i]<minBuyingPrice) {
                minBuyingPrice = prices[i];
            }
            //获取当前利润
            currentprofit = prices[i]-minBuyingPrice;
            //当前利润>0且大于最大利润时，更新最大利润
            if(currentprofit >0 && currentprofit>maxprofit){
                maxprofit = currentprofit;
            }
        }
        return maxprofit;
    }
    
}