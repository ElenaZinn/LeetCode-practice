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
 // 
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode findPos = head, p = head;
        //使用双指针找到要删除的位置
        int i =0;
        while (i<n) {
            findPos = findPos.next;
            i++;
        }
        //处理特殊情况：倒数的个数 > 链表的长度
        if (findPos ==null){
            return head.next;
        }
        
        while (findPos != null && findPos.next != null) {
            findPos = findPos.next;
            p = p.next;

        }
        p.next = p.next.next;
        return head;
        
    }
}