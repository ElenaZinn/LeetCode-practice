//https://leetcode-cn.com/problems/merge-two-sorted-lists/
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
 /**
 example
l1 = [1,2,4], l2 = 【1,3,4】
虚拟头节点：[-1]
p1.val = p2.val, [-1]-->【1】
p1.val < p2.val, [-1]-->【1】-->1
p1.val <p2.val, [-1]-->【1】-->1 -->2
p1.val > p2.val, [-1]-->【1】-->1 -->2-->【3】
p1.val = p2.val, [-1]-->【1】-->1 -->2-->【3】-->【4】
p1!=null, [-1]-->【1】-->1 -->2-->【3】-->【4】-->4
  */
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        //虚拟头结点
        ListNode mainHead  = new ListNode(-1), p=mainHead;
        ListNode p1 = list1, p2 = list2;
        while(p1 !=null && p2 !=null) {
            if(p1.val<p2.val) {
                p.next = p1;
                p1 = p1.next;
            }else{
                p.next = p2;
                p2 = p2.next;
            }
            p =p.next;
        }
        if(p1 !=null) {
            p.next = p1;
        }
        if(p2 !=null) {
            p.next = p2;
        }
        return mainHead.next;

    }
}