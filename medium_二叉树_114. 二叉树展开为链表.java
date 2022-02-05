//https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/
//hint: 后续遍历
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
    public void flatten(TreeNode root) {
        if(root == null) {
            return ;
        }
        //展平左左子树
        flatten(root.left);
        //展平右子树
        flatten(root.right);
        //获取展成链条的左右子树的起始节点
        TreeNode left = root.left;
        TreeNode right = root.right;
        //将左子树挂在root的右侧
        root.left = null;
        root.right = left;
        //将右子树挂在展平后的左子树的右侧
        TreeNode p = root;
        while(p.right!=null) {
            p = p.right;
        }
        p.right = right;
    }
}