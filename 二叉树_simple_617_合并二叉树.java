//https://leetcode-cn.com/problems/merge-two-binary-trees/
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
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        //以root1为基准，将root2合并到root1上
        /**1. base case
         */
        // 如果一棵树有，另一棵树没有，返回另一棵树
        if(root1 == null) {
            return root2;
        }
        if(root2 == null) {
            return root1;
        }
        /**2. 对根节点的操作
         */
        //两棵树都有，值相加
        root1.val += root2.val;
        /**3. 对左右子树的操作
         */
        //递归合并左右子树
        root1.left =  mergeTrees(root1.left,root2.left);
        root1.right =  mergeTrees(root1.right,root2.right);

        return root1;
    }
}