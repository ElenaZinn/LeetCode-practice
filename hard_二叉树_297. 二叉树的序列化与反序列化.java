//https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/
/**
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    String SEP = ",";
    String NULL = "#";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder s = new StringBuilder();
        serialize(root,s);
        return s.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        LinkedList<String> res = new LinkedList<>();
        //将String插入到res中
        for(String node: data.split(SEP)) {
            res.add(node);
        }

        return deserialize(res);
        
    }
    public void serialize(TreeNode root, StringBuilder s) {
        if(root==null) {
            s.append(NULL).append(SEP);
            return;
        }
        //使用前序遍历
        //对根结点的操作
        s.append(root.val).append(SEP);
        //左右子树
        serialize(root.left,s);
        serialize(root.right,s);
    
    }

    TreeNode deserialize(LinkedList<String> nodes) {
        if(nodes.isEmpty() ){
            return null;
        }
        
        //第一个就是根结点
        String first = nodes.removeFirst();
        if(first.equals(NULL)){
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(first));
        //左右子树
        root.left = deserialize(nodes);
        root.right = deserialize(nodes);
        return root;

    }

}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));