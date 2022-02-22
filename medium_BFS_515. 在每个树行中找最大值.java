//https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row/
//hint:BFS
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root== null) {
            return res;
        }
        //根结点入队
        queue.offer(root);
        while(!queue.isEmpty()){
            int width = queue.size();
            int max  = Integer.MIN_VALUE;
            //for控制每一层从左向右遍历
            for(int i=0;i<width;i++) {
                 TreeNode node = queue.poll();
                 max  = Math.max(max, node.val);
                 //左子树入队
                 if(node.left!=null){
                     queue.offer(node.left);
                 }
                 //右子树入队
                  if(node.right!=null){
                     queue.offer(node.right);
                 }
            }
            res.add(max);

        }
        return res;
    }
}