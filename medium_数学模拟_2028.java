//https://leetcode-cn.com/problems/find-missing-observations/
//思路：数学模拟
class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        
        //求得现有和， 个数*mean = 总和 现有和= 总和-缺失和， 缺失和 = 1..6之中n个数的和
        int sum = 0;
        int totalNum = n+rolls.length;
        for(int roll: rolls) {
            sum += roll;
        }
        int diff = mean * (totalNum)-sum;
        //缺失和必定>=n <=6*n, 超出这个范围是违法数字
        //从全是1开始，如果平均值<mean 则挑一个数组+1
        int base = n;
        if(diff < n || diff >6*n) {
            return new int[]{};
        }
        int[] res = new int[n];
        Arrays.fill(res,1);
        int k=0;
        while ((base + sum)/totalNum != mean ) {
            k  = k%n;
            if((base + sum)/totalNum <mean ) {
                base++;
                res[k++]++;
            }
        }
        return res;
    }
}