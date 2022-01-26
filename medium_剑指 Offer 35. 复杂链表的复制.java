//https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof/
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
/**
example
head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
step1: create copy
next:7-->[7]-->13-->[13]-->11-->[11]-->10-->[10]-->1-->[1]-->null
random: 7-->null, 13-->7,11-->1,10-->11,1-->7
//create copy's random
[7].random = null, [13].random = 7-->next = [7], [11].random =[1], [10].random = [11],[1].random = [7]
//seperate two linklist

 */
class Solution {
    public Node copyRandomList(Node head) {
        if(head ==null){
            return null;
        }
        Node cur = head;
        //创建当前结点的副本，将副本插入当前结点之后
        while(cur!=null){
            Node temp = new Node(cur.val);
            temp.next = cur.next;
            cur.next = temp;
            cur = temp.next; 
        }
        //创建副本结点的random指向
        cur = head;
        while(cur != null) {
            if(cur.random != null) {
                //副本的random = random的副本
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }
        //拆分新旧链表
        cur = head.next; //新链表表头
        Node pre = head, res = head.next;
        while(cur.next != null) {
            pre.next = pre.next.next;
            cur.next = cur.next.next;
            pre = pre.next;
            cur = cur.next;
        }
        pre.next = null; // 单独处理原链表尾节点
        return res;      // 返回新链表头节点
    }
}