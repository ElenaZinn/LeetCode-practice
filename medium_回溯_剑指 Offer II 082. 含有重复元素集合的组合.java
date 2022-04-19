//https://leetcode-cn.com/problems/4sjJUc/


class Solution {
     List<List<Integer>> res = new LinkedList<>();
     
    //  int sum=0;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        LinkedList<Integer> path = new LinkedList<>();
        Arrays.sort(candidates);
        backTrace(candidates,target,path, 0,0);
        return res;
    }
    public void backTrace(int[]candidates, int target, LinkedList<Integer> path, int start ,int curSum){
        if(curSum == target) {
            res.add(new LinkedList<>(path));
            return;
        }
        if (curSum > target) return;  //这一句很关键，不加有得用例会超时
        for(int i=start;i<candidates.length;i++) {
            
            if(i>start && candidates[i] == candidates[i-1]) {
                continue;
            }
            path.add(candidates[i]);
            curSum += candidates[i];
            backTrace(candidates,target,path, i+1,curSum);
            path.removeLast();
            curSum -= candidates[i];
        
        }
    }
}