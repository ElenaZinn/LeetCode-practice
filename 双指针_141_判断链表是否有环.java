/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        //快指针一次走两步，慢指针一次走一步；慢指针走一圈时快指针走了两圈，此时两个指针会相遇。
        boolean flag = false;
        ListNode slow,fast;
        slow = head;
        fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                flag = true;
                break;
            }
        }
        return flag;
    }
}
