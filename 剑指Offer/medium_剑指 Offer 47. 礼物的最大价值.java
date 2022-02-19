//https://leetcode-cn.com/problems/li-wu-de-zui-da-jie-zhi-lcof/
/**思路
[case1]: i=0,j=0,  是自己， grid[0][0]
【case2】: i=0,j!=0, 只能从左边到达， grid[i][j] += grid[i][j-1]
{case3}: i!=0,j=0, 只能从上边到达，grid[i][j] += grid[i-1][j]
case4: i!=0,j!=0,只能从左边或上边到达，grid[i][j] += max(grid[i][j-1],grid[i-1][j])
 */
 /**
 example
 [
  [1,3,1],  [[1],3,1], [[1],【4】,1],  [[1],【4】,【5】] 
  [1,5,1],  [1,5,1],   [1,5,1],        [1,5,1],          
  [4,2,1]   [4,2,1]    [4,2,1]         [4,2,1]          
]  
[
    [[1],【4】,【5】],   [[1],【4】,【5】],  [1],【4】,【5】],   
    [{2},5,1],          [{2},9,1],          [{2},9,10],
    [4,2,1]             [4,2,1]             [4,2,1]
]
[
    [[1],【4】,【5】],    [[1],【4】,【5】],  [[1],【4】,【5】],
    [{2},9,10],          [{2},9,10],         [{2},9,10],
    [{6},2,1]            [{6},11,1]          [{6},11,12]
]
  */
class Solution {
    public int maxValue(int[][] grid) {
        for (int i=0;i<grid.length;i++){
            for (int j=0;j<grid[0].length;j++){
                if(i==0&&j==0) {
                    continue;
                }
                if(i==0) {
                    grid[i][j] += grid[i][j-1];
                }else if(j==0) {
                     grid[i][j] += grid[i-1][j];
                }else{
                    grid[i][j] += Math.max( grid[i][j-1],grid[i-1][j]);
                }
            }
        }
        
        return grid[grid.length-1][grid[0].length-1];
    }
}