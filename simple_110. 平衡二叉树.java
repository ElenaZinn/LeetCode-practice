//https://leetcode-cn.com/problems/balanced-binary-tree/?show=1
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
    boolean isBalanced = true;
    public boolean isBalanced(TreeNode root) {
        maxDepth(root);
        return isBalanced;
    }
    public int maxDepth(TreeNode root) {
        if(root==null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        //若左右子树的深度差大于1，二叉树不平衡
        if (Math.abs(leftDepth -rightDepth) >1 ){
            isBalanced = false;
        }
        return Math.max(leftDepth,rightDepth) +1;
    }
}