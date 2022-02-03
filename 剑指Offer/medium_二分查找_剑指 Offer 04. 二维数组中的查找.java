//https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/
/**
因为行列都是单增，类似二分法，逐渐锁定行与列
special examples: [[]] 1; [] 0
 */
class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int column = 0, row = matrix.length-1;
        //row的判断条件在column前面
        while(row >=0 && column < matrix[0].length ) {
            if(matrix[row][column] >target) {
                row--;
            }else if(matrix[row][column] < target) {
                column++;
            }else{
                return true;
            }
        }
        return false;
    }
}