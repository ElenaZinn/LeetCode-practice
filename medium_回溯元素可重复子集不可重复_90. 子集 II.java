//https://leetcode-cn.com/problems/subsets-ii/
/**
回溯，元素可重复不可复选
 */
class Solution {
    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums); // 让相同元素靠在一起
        LinkedList<Integer> path = new LinkedList<>();
        backTrace(0,path,nums);
        return res;

    }
    public void backTrace(int start, LinkedList<Integer> path, int[] nums) {
        /**  这个写法也可以通过
        if(path.size()<=nums.length){
            res.add(new LinkedList<>(path));
            if(path.size()==nums.length){
                return;
            }
        }
        */
        //每个节点的值都是一个子集
        res.add(new LinkedList<>(path));
        
        for(int i=start;i<nums.length;i++) {
            //值相同，只遍历其中一条路径
            if(i > start && nums[i]==nums[i-1]) {
                continue;
            }
            path.add(nums[i]);
            backTrace(i+1,path, nums);
            path.removeLast();
        }
        
    }
}