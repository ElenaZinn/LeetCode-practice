//https://leetcode-cn.com/problems/insert-into-a-binary-search-tree/
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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        //找到空位置插入

        if(root == null) {
           return new TreeNode(val);
        }
        //值大于根节点，插入到右子树中
        if(val > root.val) {
            root.right = insertIntoBST(root.right,val);
        }
        if(val < root.val) {
            root.left = insertIntoBST(root.left,val);
        }
        return root;
    }
}