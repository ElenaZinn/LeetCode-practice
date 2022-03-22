//https://leetcode-cn.com/problems/two-sum-iv-input-is-a-bst/
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
    Set<Integer> res = new HashSet<>();
    public boolean findTarget(TreeNode root, int k) {
        //退栈条件
        if(root==null) {
            return false;
        }
        //对单个结点的操作
        if(res.contains( k-root.val)) {
            return true;
        }
        res.add(root.val);
        //搜索以root.left || root.right为起点的满足要求的两个结点和
        return findTarget(root.left, k) || findTarget(root.right,k);

    }
}