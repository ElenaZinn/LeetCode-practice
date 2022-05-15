//https://leetcode-cn.com/problems/unique-binary-search-trees/
//构造辅助递归函数，缩小区间内元素的个数来计算num
//优化：动态规划，使用一个二维数组记录当前递归结果
class Solution {
    int[][] tmp;
    public int numTrees(int n) {
        //计算闭区间[1,n]BTS树
        tmp = new int[n+1][n+1];
        return numOfBTS(1,n);
    }
    //构造辅助递归函数
    public int numOfBTS(int low, int high) {
        /** 优化前版本
         //base case 空区间
         if(low > high) {
             return 1;
         }
        //以i为根节点
        int res =0;
        for(int i=low;i<=high;i++) {
            //左子树区间为[low,i-1]
            int left = numOfBTS(low, i-1);
            //右子树区间为[i+1,high]
            int right = numOfBTS(i+1, high);
             //左右子树的乘积是BTS的总数
            res += right * left;
        }
        */
        /**优化 */
        if (low>high) {
            return 1;
        }
        int res = 0;
        if(tmp[low][high]!=0) {
            return tmp[low][high];
        }
        for (int i=low;i<=high;i++) {
            //左子树区间为[low,i-1]
            int left = numOfBTS(low, i-1);
            //右子树区间为[i+1,high]
            int right = numOfBTS(i+1, high);
             //左右子树的乘积是BTS的总数
            res += right * left;
        }
        //储存当前递归结果
        tmp[low][high] = res;
       return res;
    }
   
}