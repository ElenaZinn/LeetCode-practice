//https://leetcode-cn.com/problems/delete-node-in-a-bst/submissions/
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
 /**
 【step 1】: find first
 【step 2】: delete
 case 1: the end node, just delete it
 case 2: only has one child, let the child take place of it.
 case 3: has two child, let the max in left tree or the min in right tree to take place of it.
  */
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null) {
            return null;
        }
        //find the root
        if(root.val == key) {
            //case 1 & case 2
          if(root.left ==null) {
              return root.right;
          }
          if(root.right ==null) {
              return root.left;
          }
          //case 3:
          TreeNode maxInLeft = findMax(root.left);
          //删除左子树最大结点
          root.left = deleteNode(root.left, maxInLeft.val);
          //用这个最大结点替换root结点
          maxInLeft.left = root.left;
          maxInLeft.right = root.right;
          root = maxInLeft; 
        }else if(root.val >key ) {
            //去左子树找
            root.left =deleteNode(root.left,key);
        }else if(root.val < key) {
            //去右子树找
            root.right =deleteNode(root.right,key);
        }
        return root;

    }
    public TreeNode findMax(TreeNode root) {
        //最右侧就是最大的
        while (root.right!=null){
            root = root.right;
        }
        return root;
    }
}