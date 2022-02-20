/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/** 递归
        Step1: 遍历树找到根节点相同的结点
        Step2:通过递归判断后序的值是否相同
        Step3: 第二步失败，继续遍历树
*/
class Solution {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        boolean match = false;
        if(A==null || B==null){
            return false;
        }
        if(A.val ==B.val){
            //根结点相同，看该根节点下的左右子树是否相同
            match = isRootMatch(A,B);
        }
        if(!match) {
            //根结点不匹配，让左子树成为新的根结点
            match = isSubStructure(A.left, B);
        }
        if(!match) {
            //根结点不匹配，让右子树成为新的根结点
            match = isSubStructure(A.right, B);
        }
        return match;

    }
    public boolean isRootMatch(TreeNode A, TreeNode B) {
         if(B==null) {
            return true;
        }
        if(A==null){
            return false;
        }
        if(A.val ==B.val) {
            //root.val相等且左右子树都匹配才算是root match
            return isRootMatch(A.left,B.left) && isRootMatch(A.right,B.right);
        }else{
            return false;
        }
    }
}