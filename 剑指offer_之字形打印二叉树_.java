import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
/*
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/
public class Solution {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
// 层序遍历，需要记录层数，在偶数层进行反转 
       
        ArrayList<ArrayList<Integer> > res = new  ArrayList<ArrayList<Integer> >();        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if (pRoot==null){
            return res;
        }
        queue.offer(pRoot);

        while (!queue.isEmpty()){       
            int size = queue.size();
            LinkedList<Integer> list = new LinkedList<>();
            while (size>0){
                TreeNode temp = queue.poll();
                //处理poll出来的结点
                if (res.size() %2 ==0){
                    list.offerLast(temp.val);
                }else{
                    list.offerFirst(temp.val);
                }
                //左子树
                if (temp.left != null){
                    queue.offer(temp.left);
                }
                //右子树
                if (temp.right != null){
                    queue.offer(temp.right);
                }
                size--;
                
            }
            res.add(new ArrayList(list));
        }
        return res;
    }
}