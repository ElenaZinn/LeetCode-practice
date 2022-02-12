// https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 //从上到下打印，BFS广度优先搜索，借助队列
class Solution {
    public int[] levelOrder(TreeNode root) {
       //空值返回空数组
       if(root==null) {
           return new int[0];
       }

        Queue<TreeNode> queue = new LinkedList<>();
        LinkedList<Integer> result = new LinkedList<>();
        int[] res;
        //将根节点添加到队列中
        queue.offer(root);
        while(queue.size() != 0){
            //取出队首元素
            TreeNode node = queue.poll();
            result.add(node.val);
            //将左子树入队
            if(node.left!=null){
                queue.offer(node.left);
            }
            //将右子树入队
            if(node.right!=null) {
                queue.offer(node.right);
            }
        }
        //将LinkedList转化成int数组
        res = new int[result.size()];
        int i=0;
        for( int out:result ){
            res[i] = out;
            i++;
        }
        return res;
    }
}