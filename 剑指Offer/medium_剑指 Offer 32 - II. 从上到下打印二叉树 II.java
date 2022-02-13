//https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-ii-lcof/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    Queue<TreeNode> queue = new LinkedList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        traverse(root);
        return res;
    }
    public void traverse(TreeNode root) {
        if(root==null) {
            return;
        }
        //队首入队
        queue.offer(root);
        while(queue.size()!=0) {
            List<Integer> level = new ArrayList<>();
            for(int i = queue.size(); i > 0; i--) { //分层条件
                //队首出队
                TreeNode node = queue.poll();
                level.add(node.val);
                //左子树入队
                if(node.left!=null) {
                    queue.offer(node.left);
                }
                //右子树入队
                if(node.right!=null) {
                    queue.offer(node.right);
                }
            }
            res.add(level);
        }
    
    }
}