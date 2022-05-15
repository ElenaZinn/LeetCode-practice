/**
code link: https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/solution/
讲解：https://blog.csdn.net/qq_42500831/article/details/105331572?spm=1001.2101.3001.6650.1&utm_medium=distribute.pc_relevant.none-task-blog-2%7Edefault%7ECTRLIST%7ERate-1.pc_relevant_paycolumn_v3&depth_1-utm_source=distribute.pc_relevant.none-task-blog-2%7Edefault%7ECTRLIST%7ERate-1.pc_relevant_paycolumn_v3&utm_relevant_index=2
example
[1,2,3,4,5] m = 4,     
当前数组长度             index               最后删除元素当前位置  ([]内的是本轮需要删除的元素，【】是最后要删除的元素)
n =5               0  1  2   3  4     
                 【1】 2  3  [4] 5                   0
n =4               0  1   2  3       
                   5 【1】 2 [3]                     1
n =3               0  1   2         
                  [5] 【1】 2                       1
n =2               0  1            
                 【1】 [2]                          0
n=1                0  1
                  [【1】]                            0

从n=5 推出 n=4，【构造循环列表】
1. 将前m个元素移动到最后。     index.   0.  1. 2.   3.  4.  5.  6. 7. 8. 
                                                    5. 【1】 2  3  [4]
2. 删除最后一个元素
3. 整体前移m个元素            index.   0.  1. 2.   3.  4.  5.  6. 7. 8. 
                                     5. 【1】 2  3 
倒推: 从n=4 推出 n=5
1. 整体后移m个元素。           index.   0.  1. 2.   3.  4.  5.  6. 7. 8. 
                                                     5. 【1】 2  3 

2. 加上删除的元素              index.   0.  1. 2.   3.  4.  5.  6. 7. 8. 
                                                      5. 【1】 2  3  [4]
3.将后方的元素移到前面来        index.   0.  1. 2.   3.  4.  5.  6. 7. 8. 
（通过%n实现）                        【1】 2  3   [4]  5                       


 */
class Solution {
    public int lastRemaining(int n, int m) {
        int ans = 0;//最终只有一个
        // 最后一轮剩下2个人，所以从2开始反推
        for (int i = 2; i <= n; i++) {
            ans = (ans + m) % i; //循环右移
        }
        return ans;
    }
}