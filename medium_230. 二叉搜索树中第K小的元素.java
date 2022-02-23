//https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst/
//思路一：二叉搜索树中序遍历即升序排序。
//思路二：
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
    int res = 0;
    //当前排名
    int rank = 0;
    public int kthSmallest(TreeNode root, int k) {
        traverse(root,k);
        return res;
    }
    void traverse(TreeNode root, int k) {
        //退栈条件
        if(root == null) {
            return;
        }
        traverse(root.left, k);
        //中序遍历位置
        rank++;
        if(k == rank) {
            res = root.val;
            return;
        }
        traverse(root.right, k);
    }
}