//https://leetcode-cn.com/problems/reverse-linked-list-ii/
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
/** reverseN（head,3)
 *【input】
 * head
 *   1 --> 2-->3-->4-->5-->6-->null
 * 【output】
 * head      last    successor
 *   1 -->2<--3         4     -->5-->6->null
 *     <-
 * head      last    successor
 *   1 <--2<--3         4     -->5-->6->null
 *     ---------------->
 */
class Solution {
    ListNode successor = null;
    public ListNode reverseBetween(ListNode head, int left, int right) {
        //base case
        if(left==1) {
            return reverseN(head,right);
        }
        //Recursion until meet base case
        head.next = reverseBetween(head.next, left-1,right-1);
        return head;
    

    }
    public ListNode reverseN(ListNode head, int n) {
        //base case
        if(n==1) {
            successor = head.next;
            return head;
        }
        //以head.next为起点，需要翻转n-1个节点
        ListNode last = reverseN(head.next,n-1);
        head.next.next = head;
        head.next = successor;
        return last;
    }
}