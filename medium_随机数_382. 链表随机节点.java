//https://leetcode-cn.com/problems/linked-list-random-node/
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
 solution1: store all data in a list, then retrun a random value
            disadvantage: waste time and space
solution2: 水塘取样 随机数从链表头开始，遍历整个链表，对遍历到的第 i个节点，随机选择区间 [0,i)内的一个整数，如果其等于 00，则将答案置为该节点值，否则答案不变。
  */
class Solution {
    ListNode head;
    Random r = new Random();
    public Solution(ListNode head) {
        this.head = head;
    }
    
    public int getRandom() {
        int i=0,res = 0;
        ListNode p   = head;
        while(p!=null) {
            i++;
            // 这个整数等于 0 的概率就是 1/i
            if(0==r.nextInt(i)) {
                res = p.val;
            }
            p = p.next;
        }
        return res;
    }
    
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */