//https://leetcode-cn.com/problems/dui-cheng-de-er-cha-shu-lcof/submissions/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) {
            return true;
        }
        return isEquals(root.left,root.right);
    }
    
    private boolean isEquals(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        return root1.val == root2.val && isEquals(root1.left, root2.right)
                && isEquals(root1.right, root2.left);
    }


}