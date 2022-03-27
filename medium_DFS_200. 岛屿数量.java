//https://leetcode-cn.com/problems/number-of-islands/
class Solution {
    
    public int numIslands(char[][] grid) {
        int res = 0;
        int m = grid.length, n = grid[0].length;
        //遍历二维矩阵
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(grid[i][j] == '1') {
                    res++; //岛屿数量+1
                    //用dfs淹没岛屿
                    dfs(grid,i,j);
                }
            }
        }
        return res;
    }

    public void dfs(char[][] grid, int row, int col){
        //超出索引边界
        int m = grid.length, n = grid[0].length;
        if(row<0 || col<0 || row>=m || col >=n){
            return;
        }
    
        if(grid[row][col] =='0') {
            //被访问过或本来就是海水
           return ;
        }
        //通过上下左右触及到另一个岛
        grid[row][col] ='0';
        dfs(grid, row-1,col); //上
        dfs(grid, row+1,col); //下
        dfs(grid, row,col-1);//左
        dfs(grid, row,col+1);//右


    }
}