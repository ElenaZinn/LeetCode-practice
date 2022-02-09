//https://leetcode-cn.com/problems/find-duplicate-subtrees/
/**思路:
知道自己长啥样：单个结点将树序列化（序列化使用后序遍历）
知道别人长啥样：借助HashMap，让每个节点把自己子树的序列化结果存进去
对比自己与别人，记录重复的root
注意：不使用HashSet，因为res中会有重复的值
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
    // 记录重复的子树根节点
    LinkedList<TreeNode> duplicateRoot = new LinkedList<>();
    // 记录所有子树
    HashMap<String,Integer>  subTrees= new HashMap<>();
    
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
            traverse(root);
            return duplicateRoot;
    }

    String traverse(TreeNode root) {
        //空节点使用#填充
        if(root==null) {
            return "#";
        }
        //后序遍历
        String left = traverse(root.left);
        String right = traverse(root.right);
        String subTree = left + "," + right + "," + root.val;

        //对比查找重复的子树
        int occurrence = subTrees.getOrDefault(subTree, 0);
        if(occurrence == 1){
            duplicateRoot.add(root);
        }
        subTrees.put(subTree, occurrence +1);
        return subTree;
    }
}