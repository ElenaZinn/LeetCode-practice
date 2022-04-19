//https://leetcode-cn.com/problems/permutations/

class Solution {
    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> path = new LinkedList<>();
        //访问过的路径标记为true，防止重复访问
        boolean[] used = new boolean[nums.length];
        backTrace(used, path, nums);
        return res;
    }
    /**
     *@param used: 访问过的路径标记为true，防止重复访问
     *@param path: 访问的路径
     *@param nums: 可以做的选择
     */
    public void backTrace(boolean[] used, LinkedList<Integer> path, int[] nums){
        //遍历决策树
        //满足条件遍历到叶子节点了，可以加入到path中
        if(path.size()== nums.length){
            res.add(new LinkedList(path));
            return;
        }
        //for 选择 in 选择列表
        for(int i=0;i<nums.length;i++) {
            if(used[i]) {
                //被选用过
                continue;
            }
             //做选择  （从父节点进入到子节点）
            used[i] = true;
            path.add(nums[i]);
            //下一层回溯
            backTrace(used, path, nums);
            //撤销选择 （从子节点回退到父节点）
            path.removeLast();
            used[i] = false;
        }
       

    }
}