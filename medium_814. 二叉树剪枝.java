// https://leetcode-cn.com/problems/binary-tree-pruning/?show=1
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
    public TreeNode pruneTree(TreeNode root) {
        if(root == null) {
            return null;
        }
        //递归，对左右子树的操作
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        //对单个节点的操作
        //如果自己是叶子结点，且值为0，删除自己
        if(root.val==0 && root.left==null && root.right == null) {
            return null;
        }
        //不是，正常返回
        else return root;
        

    }
}