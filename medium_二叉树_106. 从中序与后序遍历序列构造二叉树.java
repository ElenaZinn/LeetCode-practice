//
/**图解
          preStart         preStart+leftsize    preEnd
preorder  root [     root.left    ]  【   root.right  ]

          iStart   index-1    index index+1        iEnd
inorder   [   root.left      ]  root [   root.right  ]     
          

         pStart     pStart+leftSize-1           pEnd-1 pEnd
postorder [     root.left    ]  [  root.right  ]  root
*/
/** 思路
以postorder为主，inorder辅助确定左右子树的区间
 */
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder,0,inorder.length-1, postorder,0,postorder.length-1);
    }
    public TreeNode build(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        //退栈条件
        if(postStart > postEnd) {
            return null;
        }
        //确认根节点的val
        int rootval = postorder[postEnd];
        //根节点在inorder的index
        int index=0;
        for(int i=0;i<inorder.length;i++) {
            if(inorder[i]==rootval) {
                index = i;
                break;
            }
        }
        int leftSize = index-inStart;

        //构造根节点
        TreeNode root = new TreeNode(rootval);
        //构造左右子树
        root.left = build(inorder,inStart,index-1, postorder,postStart, postStart +leftSize-1);
        root.right = build(inorder,index+1, inEnd, postorder,postStart+leftSize,postEnd-1);
        return root;
    }
}