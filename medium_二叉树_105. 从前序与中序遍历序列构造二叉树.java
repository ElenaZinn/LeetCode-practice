//https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
/**图解
          preStart         preStart+leftsize    preEnd
preorder  root [     root.left    ]  【   root.right  ]

          inStart   index-1    index index+1      inEnd
inorder   [   root.left      ]  root 【   root.right  ]     
          ｜<--leftSize->｜
 */
 /**思路：先构造出当前根节点，再构造出左右子树
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, 0, preorder.length-1, inorder,0,inorder.length-1);
    }

    public TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        /** 1.退栈条件 */
        if(preStart > preEnd){
            return null;
        }

        /** 2.对根节点的操作 */
        //前序遍历数组的第一个元素是根节点
        int rootVal = preorder[preStart];
        //获取root在中序遍历的索引index
        int index = 0;
        for(int i=0;i<inorder.length;i++){
            if(inorder[i]==rootVal) {
                index = i;
                break;
            }
        }
        int leftSize = index-inStart;
        /** 3.中序遍历 */
        //构造根节点
        TreeNode root = new TreeNode(rootVal);
        //递归构造左右子树
        root.left = build(preorder,preStart+1,preStart+leftSize, inorder, inStart, index-1);
        root.right =build(preorder,preStart + leftSize +1, preEnd,inorder, index +1, inEnd);
        return root;
    }
}