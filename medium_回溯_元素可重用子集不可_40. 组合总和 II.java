//https://leetcode-cn.com/problems/combination-sum-ii/
//在https://leetcode-cn.com/problems/subsets-ii/ 基础上改动
/**
和为target的子集
元素可重不可复选
 */
class Solution {
    List<List<Integer>> res = new LinkedList<>();
    int sum = 0;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        LinkedList<Integer> path = new LinkedList<>();
        backTrace(candidates,path,target,0);
        return res;

    }

    public void backTrace(int[] candidates,LinkedList<Integer> path , int target, int start) {
        if(sum ==target){
            res.add(new LinkedList<>(path));
            return;
        }
        if(sum > target) {
            return;
        }

        //在可选择的循环中
        for(int i=start;i<candidates.length;i++) {
            if(i>start && candidates[i]==candidates[i-1]){
                continue;
            }
            path.add(candidates[i]);
            sum += candidates[i];
            backTrace(candidates,path,target,i+1);
            path.removeLast();
            sum -= candidates[i];
        }

    }
}