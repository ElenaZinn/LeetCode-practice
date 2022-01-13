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
 // 链表头到环入口的距离=相遇点到环入口的距离+（k-1）圈数环长度
//low从链表头出发，fast从相遇点出发，以相同速度遍历最终一定在入口处相遇
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        if(slow==null){
            return null;
        }
        while (fast.next != null && fast.next.next != null ){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast){
                break;
            }
        }
         if (fast.next==null || fast.next.next==null){
            return null;
        }
        slow = head;
        while (fast != slow){
            slow = slow.next;
            fast = fast.next;
        }

        return fast;
    }
}
