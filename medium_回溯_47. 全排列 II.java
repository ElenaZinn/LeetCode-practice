//https://leetcode-cn.com/problems/permutations-ii/
/**
若子集不能重复，需要剪枝，即排序后，相同数值的枝被剪掉
 */
class Solution {
    List<List<Integer>> res = new LinkedList<>();
    boolean[] used;
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        LinkedList<Integer> path = new LinkedList<>();
        used = new boolean[nums.length]; //使用used避免添加重复元素
        backTrace(path,nums);
        return res;
    }
    public void backTrace(LinkedList<Integer> path, int[] nums){
        if(path.size()==nums.length){
            res.add(new LinkedList<>(path));
            return ;        //返回语句，我总是忘记
        }
        for(int i=0;i<nums.length;i++){
            if(used[i]){
                continue;
            }
            if(i>0 && nums[i] == nums[i-1] && !used[i-1]){   // 为什么used是i-1呀？
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            backTrace(path, nums);
            path.removeLast();
            used[i] = false;
        }
    }
}