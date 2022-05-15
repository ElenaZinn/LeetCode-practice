//https://leetcode-cn.com/problems/binary-tree-paths/
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
思路：深度优先遍历
非递归：借助栈
  
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        
        if(root==null) {
            return res;
        }
        Deque <Object> stack = new LinkedList<>(); //使用object即可以添加TreeNode，又可以添加String
        stack.push(root);
        stack.push(root.val + ""); //Intger 变为String

        while (!stack.isEmpty()) {
            String path = (String) stack.pop();  //需要强制类型转化
            TreeNode node =(TreeNode)stack.pop();
            
            if(node.left == null && node.right == null) {
                res.add(path);
            }

            //右子树入栈  //!!!!!!!右子树在前,因为右子树先入后出
            if(node.right !=null) {
                stack.push(node.right);
                stack.push(path + "->" + node.right.val);
                System.out.println("右子树中path = " + path);
            }
            //左子树入栈
            if(node.left!=null) {
                stack.push(node.left);
                stack.push(path + "->" + node.left.val);
                System.out.println("左子树中path = " + path);
            
            }
        
        }
        return res;
    }
    
}
*/

//递归
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        helper(root,"",res);
        return res;
        
    }
    public void helper(TreeNode root, String path, List<String>res) {
        //使用StringBuffer记住路径
        if(root==null ){
            return ;
        }
        StringBuilder tmpPath = new StringBuilder(path);
        tmpPath.append(Integer.toString(root.val));

        //叶子节点加入路径且不需要->
        if(root.left==null && root.right==null) {
            res.add(tmpPath.toString());
        }else{
            //非叶子节点，遍历左右子树且需要加上->
            tmpPath.append("->");
            helper(root.left, tmpPath.toString(),res);
            helper(root.right, tmpPath.toString(),res);
        }
        
    }
}