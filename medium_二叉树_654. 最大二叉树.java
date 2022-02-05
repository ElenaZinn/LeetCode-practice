//https://leetcode-cn.com/problems/maximum-binary-tree/
//hint：中序遍历
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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums,0,nums.length-1);
        
    }
    public TreeNode build(int[] nums, int start, int end) {
        int indexOfMax =0;
        //退栈条件
        if(start>end) {
            return null;
        }

        //找到序列中的最大值
        int max = Integer.MIN_VALUE; //使用别的值会有StackOverflowError
        for (int i=start;i<=end;i++) {
            if(nums[i]>max) {
                max = nums[i];
                indexOfMax = i;
            }
        }

        //构造根节点
        TreeNode root = new TreeNode(max);
        //构造左子树：最大值的左侧是左子树
        root.left = build(nums,start, indexOfMax-1);
        //构造右子树：最大值的右侧侧是右子树
        root.right = build(nums,indexOfMax +1, end);
        return root;
    }
}