//https://leetcode-cn.com/problems/trim-a-binary-search-tree/submissions/
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
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if(root== null ) {
            return null;
        }
        //若比low小，返回右子树
        if(root.val<low) {
            return trimBST(root.right, low, high);
        }
        //若比high大，返回左子树
        if(root.val > high) {
            return trimBST(root.left, low, high);
        
        }
        //在[low,high]范围内，无操作
        root.left = trimBST(root.left, low, high);
        root.right =  trimBST(root.right, low, high);
        return root;
    }
}