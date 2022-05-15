//https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node/
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root == null) {
            return null;
        }
        connectTowNode(root.left, root.right);
        return root;
    }
    public void connectTowNode(Node one, Node two) {
        if(one == null || two ==null) {
            return;
        }
        //连接两个节点
        one.next = two;
        //连接父节点的左右子节点
        connectTowNode(one.left, one.right);
        connectTowNode(two.left, two.right);
        //连接同层不同父节点的子节点
        connectTowNode(one.right, two.left);
    }
}