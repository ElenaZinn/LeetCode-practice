//https://leetcode-cn.com/problems/binary-gap/
/**
位运算 
 */
class Solution {
    public int binaryGap(int n) {
        int ans = 0;
        for(int i=31,j=-1 ; i>=0;i--) {
            if(((n >> i) & 1) == 1) {
                if(j!=-1) {
                    ans = Math.max(ans, j - i);
                }
                j=i;
            }
            
        }
        return ans;
    }
}