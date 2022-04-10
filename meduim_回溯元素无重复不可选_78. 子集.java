//https://leetcode-cn.com/problems/subsets/
/**
元素无重复不可选
回溯
*/
class Solution {
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> subsets(int[] nums) {
        backTrace(nums,0);
        return res;
    }
    /**
    *@param  nums:可以的选择
    *@param  level: 每一层的元素和层数相等
    */
    public void backTrace(int[] nums,int level ){
        //满足条件
        /** 
        if(path.size()==level){     //这种写法得倒的是定长
            res.add(new LinkedList(path));
        }
        */
        //前序的位置，每个节点都是子集
        res.add(new LinkedList<>(path));

        //在可供选择的循环中
        for(int i=level;i<nums.length;i++) {     //i 的起始值是level
            //做出选择
            path.addLast(nums[i]);
            //遍历下一层
            backTrace(nums,i+1);     // 是i+1，不是level +1
            //撤销选择
            path.removeLast();
        }
    }
}