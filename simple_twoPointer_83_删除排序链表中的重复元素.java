//https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
//example, same as T26 https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/

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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode fast = head, slow = head;
        if(head == null) {
            return null;
        }
        while (fast!=null){
            if(slow.val !=fast.val){
                slow = slow.next;
                slow.val  = fast.val;
            }
            fast = fast.next;
        }
        slow.next=null; //切断多余链表
        return head;
    }
}