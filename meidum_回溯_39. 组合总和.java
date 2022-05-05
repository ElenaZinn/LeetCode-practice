//https://leetcode-cn.com/problems/combination-sum/
/**
可以多次使用
 */
class Solution {
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();
    int sum = 0;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backTrace(candidates,target,0);
        return res;
    }
    public void backTrace(int[] candidates, int target, int start) {
        if(sum  == target) {
            res.add(new LinkedList<>(path));
            return;
        }
        if (sum > target) {
            // 超过目标和，直接结束
            return;
        }
        for(int i=start;i<candidates.length;i++) {
            path.add(candidates[i]);
            sum += candidates[i];
            backTrace(candidates,target,i);
            path.removeLast();
            sum -= candidates[i];
        }
    }
}