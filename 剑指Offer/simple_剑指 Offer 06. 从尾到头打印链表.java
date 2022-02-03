//https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public int[] reversePrint(ListNode head) {
        ArrayList<Integer> arr = new ArrayList<>();
        while (head!=null){
            //将链表的数值复制到Arraylist中
            arr.add(head.val);
            head =head.next;
        }
        int n = arr.size();
        int[] list = new int[n];
        for(int i=n-1;i>=0;i--){
            //将ArrayList的值反转到数组中
            list[i] = arr.get(n-i-1);
        }
        return list;
    }
}