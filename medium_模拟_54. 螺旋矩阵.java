import java.util.*;

/**
 遍历矩阵的几种情况
 //init
 int horizontal_level = 0
 end1 =0, end2=matrix.length, end3 = end1

 i = horizontal_level%2==0 , j++   右箭头
    if( j==end1 ) i++ till end2, level ++;
 i= horizontal_level%2!=0, j--;
    if( j==end3 ) i-- till end4 = end1+1;

 在边界问题上花费了很长时间。。。
 上面的分析还可以再细节一些的
 */

/**
 * 从左到右（top,left)  (top,right)
 * 从上到下（top+1,right), (bottom,right)
 * 从右到左（bottom,right-1) (bottom, left+1)
 * 从下到上(bottom,left) (top+1,left)
 */
class Solution {
    /**
     * @deprecated
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res =new ArrayList<>();
        int level = 0; // to control direction
        int i=0,j=0; // for traverse
        int[] ends = new int[]{1,matrix[0].length,matrix.length,0};  //traverse boundary
        //init ends
        int finish = matrix.length * (matrix[0].length),p=0;
         while (p<finish) {
             System.out.println("level = " + level);
             if(level%2==0) {//index increases
                 while(j < ends[1]) {
                 //从左向右遍历，先添加再变序号
                     res.add(matrix[i][j]);
                     j++;
                     System.out.println("end1---- i = " + i + " j = " + j);
                     p++;
                 }
                 ends[1]--;
                 System.out.println("end1-----" + res.toString());
                 j--;
                 while(i <ends[2]) {
                 //从上到下遍历,先变序号再添加
                     i++;
                     if(i== ends[2]) {
                         break;
                     }
                     System.out.println("end2 ----- i = " + i + " j = " + j);
                     res.add(matrix[i][j]);
                     p++;

                 }
                 ends[2]--;
                 level++;
                 System.out.println("end2-----" + res.toString());
                 continue;

             }else{   //index decreases
                 System.out.println("ends[3] = " + ends[3]);
                 while(j > ends[3]  ) {
                 //从右向左，先变序号再添加

                     j--;
                     if(j== ends[3] ) {
                         break;
                     }
//                     System.out.println("ends[3] = " + ends[2]);
                     if(i==ends[2] +1){
                         i--;
                     }
                     System.out.println("end3---- i = " + i + " j = " + j);
                     res.add(matrix[i][j]);
                     p++;
                 }
                 System.out.println("end3-----" + res.toString());
                 ends[3]++;
                 while(i > ends[0]) {
                     //从下向上，先添加再变序号
                     System.out.println("end4---- i = " + i + " j = " + j);
                     if(i >= ends[0]){
                         i--;
                     }
                     res.add(matrix[i][j]);
                     i--;
//                     System.out.println("end4---- i = " + i + " j = " + j);

                     p++;

                 }
                 System.out.println("end4-----" + res.toString());
                 ends[0]++;
                 level++;
                 System.out.println(res.toString());
                 continue;
             }
         }
             //        res.add(matrix[i+1][j+1]);
             return res;
         }
         */


    public List<Integer> spiralOrder_2(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        //不合法的输入
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        int rows = matrix.length, columns = matrix[0].length;
        int left = 0, right = columns - 1, top = 0, bottom = rows - 1;
        while(left<=right && top <=bottom) {
            for(int column = left ; column<= right;column ++) { //从左到右
                res.add(matrix[top][column]);
            }
            for(int row = top+1; row<=bottom; row++) {// 从上到下
                res.add(matrix[row][right]);
            }
            if(left<right && top<bottom) {
                for(int column = right-1 ; column> left;column --) { //从右到左
                    res.add(matrix[bottom][column]);
                }
                for(int row = bottom; row > top; row--) {// 从上到下
                    res.add(matrix[row][left]);
                }
            }
            left++;
            right--;
            top++;
            bottom--;
         }
        return res;
    }
}

class Soo{
    public static void main(String[] args) {
//        int[][] nums =new int[][]{{1,2,3},{4,5,6},{7,8,9}};
//        int[][] nums =new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        int[][] nums =new int[][]{{1,2},{3,5}};
//        System.out.println(nums.length + " " + nums[0].length);
        Solution s = new Solution();
        System.out.println(s.spiralOrder_2(nums).toString());

    }
}
