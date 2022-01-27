//同 leetcode 206 https://leetcode-cn.com/problems/reverse-linked-list/
 /**
example
【input】
head
   1  -->2-->3-->4-->5-->6-->NUll

【last = reverse(head.next)】
head
   1  -->reverse(2-->3-->4-->5-->6-->NUll)

head
   1  --> 2 <--3<--4<--5<--6
         NUll
【head.next.next = head;】
head                   last
  1 --> 2<--3<--4<--5<--6
    <--
【head.next = null】
NUll<--1<--2<--3<--4<--5<--6
  */
  class Solution {
    public ListNode reverseList(ListNode head) {
        //base case；
        if(head==null||head.next==null) {
            return head;
        }
        ListNode last = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return last;

    }
}