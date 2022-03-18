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
 // 一棵完全二叉树的两棵子树，至少有一棵是满二叉树
class Solution {
    public int countNodes(TreeNode root) {
        //左右子树
        TreeNode leftNode = root, rightNode = root;
        //记录高度
        int leftDepth = 0, rihgtDepth=0;
        while(leftNode!=null) {
            leftNode = leftNode.left;
            leftDepth++;
        }
        while(rightNode!=null) {
            rightNode = rightNode.right;
            rihgtDepth ++;
        }
        //如果左右子树高度相同，是满二叉树，节点数用固定公式计算
        if(leftDepth == rihgtDepth) {
            return (int)Math.pow(2,leftDepth)-1;
        }
        //高度不等，按照普通树的节点数计算
        return countNodes(root.left) + countNodes(root.right) +1;
    }
}