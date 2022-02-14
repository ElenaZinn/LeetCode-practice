//https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof/submissions/
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
    public TreeNode mirrorTree(TreeNode root) {
        if(root==null) {
            return null;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        //交换左右子树的根
        root.left = mirrorTree(root.left);
        root.right = mirrorTree(root.right);
        return root;
    }

}