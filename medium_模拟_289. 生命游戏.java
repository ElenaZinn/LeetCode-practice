//https://leetcode-cn.com/problems/game-of-life/
/**
使用-1，0，1，2复合状态辅助

 */
class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[] neiPos = new int[]{0,1,-1};
        //遍历每一个细胞
        for(int row =0;row<m;row++) {
            for(int column = 0; column<n;column ++) {
                int liveNum = 0;// 记录周围细胞存活个数
                //检查邻居细胞的存活情况，更新自己的状态，注意边界问题
                for(int i=0;i<3;i++) {
                    for(int j=0;j<3;j++) {
                        if(!(neiPos[i] ==0 && neiPos[j]==0)) {
                            //相邻位置的坐标
                            int r = (row + neiPos[i]);
                            int c = (column + neiPos[j]);
                            // 查看相邻的细胞是否是活细胞
                            if ((r < m && r >= 0) && (c < n && c >= 0) && (Math.abs(board[r][c]) == 1)) {
                                liveNum += 1;
                            }
                        }
                    }
                }

                //规则1，3 过去是活的，现在是死的：令状态等于-1
                if(board[row][column] ==1 && (liveNum<2|| liveNum >3)) {
                    board[row][column]=-1;
                }
                //规则2: 不用变，还是1
                //规则4:之前是死的，现在是活的：令状态等于2
                if(board[row][column] ==0 && liveNum == 3) {
                    board[row][column]=2;
                }
            }
        }

        //再次遍历细胞，将复合状态转变为0，1数组
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(board[i][j] > 0) {
                    board[i][j] =1;
                }else{
                    board[i][j] =0;
                }
            }
        }
    }
}