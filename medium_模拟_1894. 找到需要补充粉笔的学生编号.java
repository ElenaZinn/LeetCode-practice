//https://leetcode-cn.com/problems/find-the-student-that-will-replace-the-chalk/
/**
index = (i+index)%chalk.length
 */
class Solution {
    /**
    *    
    最后输入 [1] 1000000000 超出时间限制  因为消耗粉笔总数超出了限制
    public int chalkReplacer(int[] chalk, int k) {
        int i=0;
        int n=chalk.length;  
        int res =0 ;
        while(k >=0) {
            for(int j=0;j<chalk.length;j++) {
                int index = (i+j)%n;
                k-=chalk[index];
                if(k==0 ||(index+1<chalk.length &&  k< chalk[index+1] )) { //粉笔用完或者不够用的
                    res = (j+1)%chalk.length;
                    return res;
                }
            }
            i+=chalk.length;
        }
        return res;
    }
     */
     /**
     优化：使用k%sum
      */
     public int chalkReplacer(int[] chalk, int k) {
        int n=chalk.length;  
        long sum = 0;   //！！！！需要使用64位
        for(int ch:chalk) {
            sum +=ch;
        }
        k%=sum;
        int res =-1;
        for(int j=0;j<n;++j) {
            if(chalk[j] >k) { //需要量>剩余量
                res = j;
                break;
            }
            k-=chalk[j];
               
        }
        return res;
    }
}