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
 /**
 直径长度：左子树的最大长度+右子树的最大长度
  */
class Solution {
    int maxDemi =0;

    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return maxDemi;
    }
    public int maxDepth(TreeNode root) {
        if(root ==null){
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        maxDemi = Math.max(maxDemi, left +right);
        return 1+Math.max(left,right);
    } 
}