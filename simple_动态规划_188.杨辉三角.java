/**
第一层   1
            1
第二层   1  1              
            1  1
第三层   1  2  1             2 = [2][1] = res.get(i - 1).get(j - 1) + res.get(i - 1).get(j)
            1  2  1
第四层   1  3  3  1
            1  3  3  1
第五层   1  4  6  4  1

每一层首尾数据都为1，直接赋值
由最外层递归到第一层，接着每层的数据都由上一层错位相加（last.get(i) + last.get(i-1)）得出
 */
class Solution {
    public List<List<Integer>> generate(int numRows) {
        
        List<List<Integer>> res = new ArrayList<>();
        for (int i=0;i<numRows;i++) {
            List<Integer> level = new ArrayList<>();
            for (int j=0;j<=i ;j++) {
                if(j==0 || j==i) {
                    level.add(1);
                }else{
                    level.add(res.get(i-1).get(j-1) + res.get(i - 1).get(j));
                }
            }
            res.add(level);
        }
       return res;
    }
}