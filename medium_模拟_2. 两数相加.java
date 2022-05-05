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
    /**
    思路是对的但还有更好的写法
     */
    public ListNode addTwoNumbers_self(ListNode l1, ListNode l2) {
        
        int carry = 0; //进位
        //求两个链表长度
        ListNode p = l1, q = l2;
        int len1 = 0, len2 = 0;
        while(p!=null) {
            p = p.next;
            len1++;
        }
        while(q!=null) {
            q = q.next;
            len2++;
        }
        // System.out.println("len1 = " + len1 + " len2 = " + len2);
        ListNode  base = len1<= len2 ? l2:l1; //以长的链表为基准，最后也是返回长的链表
        ListNode res = base;//记录base的头指针，也是最终要返回的参数
        ListNode added =  len1<= len2 ? l1:l2; //被加数
        ListNode pre_tail = null;
        // System.out.println("base = " + base.val + " added = " + added.val);

        while(added!=null) {
            int sum = base.val+added.val + carry;
            if(sum >=10) {
                carry = 1;  //有进位
            }else{
                carry =0;   //没有进位
            }
            base.val = sum%10;  //原位置上只保留两值相加的个位数
            // System.out.println("+++++++ base = " + base.val );

            if(base.next==null) {
                pre_tail = base;
            }

            //同时移动
            added = added.next;
            base = base.next;
        }
        // System.out.println("======= base = " + base.val + " added = " + added.val);
        
        while(len1!=len2 && base!=null) {
            int sum = base.val+ carry;
             if(sum >=10) {
                carry = 1;
            }else{
                carry =0;   //没有进位
            }
            base.val = sum%10;  //原位置上只保留两值相加的个位数
            if(base.next==null) {
                pre_tail = base;
            }
            base = base.next;
        }
        //处理最后一个进位
        if (carry==1) {
             pre_tail.next = new ListNode(1);
        }
        return res;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1 = l1, p2 = l2;
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        int carry = 0, newVal = 0;
        while (p1 != null || p2 != null || carry > 0) {
            newVal = (p1 == null ? 0: p1.val) + (p2 == null ? 0: p2.val) + carry; 
            carry = newVal / 10;
            newVal %= 10;
            p.next = new ListNode(newVal);
            p1 = p1 == null? null: p1.next;
            p2 = p2 == null? null: p2.next;
            p = p.next;
        }
        return dummy.next;
    }
}