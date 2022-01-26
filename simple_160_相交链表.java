//https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
//p1遍历完A后便利B，p2遍历B后遍历A，这样达到公共节点之前，p1,p2走过的长度相等
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
 /**example
 intersectVal = 8, listA = [4,1,8,4,5], listB = 5,6,1,8,4,5, skipA = 2, skipB = 3
p1  4 --> 1 --> 8 --> 4--> 5--> [5]-->[6]-->[1]-->【8】
p2 [5]-->[6]-->[1]-->[8]-->[4]-->[5]-->4 --> 1 -->【8】
  */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA, p2 =headB;
        while(p1!=p2) {
            if(p1 != null){
                p1 = p1.next;
            }else{
                //headA遍历完了，遍历headB
                p1 =headB;
            }
            if(p2 != null) {
                p2 = p2.next;
                
            }else{
                p2 = headA;
            }
        }
        return p1;
        
    }
}