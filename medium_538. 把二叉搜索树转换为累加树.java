//https://leetcode-cn.com/problems/convert-bst-to-greater-tree/
//hint: 中序遍历可以得到升序
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
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        traverse(root);
        return root;
    }
    public void traverse(TreeNode root) {
        //退栈条件
        if(root==null) {
            return;
        }
        //右子树
        traverse(root.right);
        //中序操作
        sum += root.val;
        root.val = sum;
        //左子树
        traverse(root.left);
    }
}