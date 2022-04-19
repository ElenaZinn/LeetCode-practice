//https://leetcode-cn.com/problems/combinations/
/**
元素无重不可复选
回溯
 */
 
class Solution {
    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> combine(int n, int k) {
        LinkedList<Integer> path = new LinkedList<>();
        backTrace(1,path,n,k);
        return res;
    }
    
    public void backTrace(int start, LinkedList<Integer> path, int n, int k){ //start 用来控制遍历层数，防止出现重复子集
        //满足条件
        if(k==path.size() ) {
            res.add(new LinkedList<>(path));
            return;
        }
     
        for(int i=start;i<=n;i++) {
            //做选择
            path.addLast(i);
            //下一层
            backTrace(i+1,path, n,k);   //注意这里是i+1,不是start+1
            //取消选择
            path.removeLast();
        }
        
       
    }
    
    
}

