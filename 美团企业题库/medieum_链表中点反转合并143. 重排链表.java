//https://leetcode.cn/problems/reorder-list/ 
/**
hint: fins mid point, reverse and merge
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if(head==null) {
            return;
        }
        //find mid point
        ListNode slow = head, fast =head;
        while(fast.next!=null && fast.next.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // System.out.println(slow.val);
        
        
        ListNode tmphead = slow.next;
        slow.next = null;
        //reverse
        ListNode pre = null;
        ListNode cur = tmphead;
        while(cur!=null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        // System.out.println(pre.val);
        // System.out.println(pre.next.val);
        ListNode l1 = head;
        merge(l1, pre);
    }
    public void merge(ListNode p1, ListNode p2) {
        ListNode tmp1 , tmp2;
        while(p1!=null && p2!=null) {
            tmp1 = p1.next;
            tmp2 = p2.next;

            p1.next = p2;
            p1 = tmp1;

            p2.next = p1;
            p2 = tmp2;
            
        }
    }
}