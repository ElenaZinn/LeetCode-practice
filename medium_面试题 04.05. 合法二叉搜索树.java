//https://leetcode-cn.com/problems/legal-binary-search-tree-lcci/
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
    public boolean isValidBST(TreeNode root) {
        return valid(root, null, null);
    }
    public boolean valid(TreeNode root, TreeNode min, TreeNode max) {
        //base case
        if(root == null){
            return true;
        }
        if(min!=null && root.val <= min.val) {
            return false;
        }
        if(max != null && root.val >= max.val) {
            return false;
        }
        //遍历左子树时，最大值是root， 遍历右子树时，最小值是root
        return valid(root.left, min, root) && valid(root.right, root, max);
    }
}