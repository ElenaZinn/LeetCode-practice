//https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head==null) {
            //链表为空，返回null
            return null;
        }
        ListNode p = head.next,post = null;
        //head后置空，使head成为单独的一个结点
        head.next = null;
        //采用头插法将链表插入到head之前
        while(p!=null) {
            post = p.next;
            p.next = head;
            head = p;
            p = post;
        }
        return head;
        
    }
}