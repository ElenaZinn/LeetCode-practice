//https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
//遍历树实际上是进栈退栈
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
    /**
    后序遍历
    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left,right) +1;

    }
     */
    int res= 0;
    int depth =0;
    public int maxDepth(TreeNode root) {
        traverse(root);
        return res;
    }
    public void traverse(TreeNode root) {
        //pop stack condition
        if(root==null){
             res = Math.max(res,depth);
             return;
        }
       
        depth++;
        traverse(root.left);
        traverse(root.right);
        depth--;
    }
}