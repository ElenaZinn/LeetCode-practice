//https://leetcode-cn.com/problems/next-greater-element-i/submissions/
/** 思路
单调栈解决(栈中只存放比当前值高的元素，高的留下，低的弹出)
若后一个比前一个大：{key = 前一个，value = 后一个}
若后一个小于前一个：{key = 前一个，value = -1}
 */
 /**
 example nums1 = [4,1,2], nums2 = [1,3,4,2]
 in function nextGreaterHelper(nums2):
 i=3, no loop, map = [2:-1], stack = [2]
 i=2, in while, stack = [], map = [2:-1, 4:-1], stack=[4]
 i=1, no loop, stack=[4], map = [2:-1, 4:-1,3:4],stack =[4,3]
 i=0, no loop, stack=[4,3], map = [2:-1, 4:-1,3:4,1:3], stack =[4,3,1]

  */
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res  = new int[nums1.length];
        Map<Integer, Integer> nextGreater = nextGreaterHelper(nums2);
        for(int i=0;i<nums1.length;i++) {
            res[i] = nextGreater.get(nums1[i]);
        }
        return res;
    }

    public Map<Integer, Integer> nextGreaterHelper(int[] nums) {
         Map<Integer, Integer> map = new HashMap<>();
         Stack<Integer> forCompare = new Stack<>();
         for (int i = nums.length-1;i>=0;i--) {
            while(!forCompare.isEmpty() && forCompare.peek() <=nums[i]){
                //若后一个小于前一个，小的元素不入栈
                forCompare.pop();
            }
            //若后一个比前一个大：{key = 前一个，value = 后一个}
            // 若后一个小于前一个：{key = 前一个，value = -1}
            map.put(nums[i],forCompare.isEmpty()? -1:forCompare.peek());
            forCompare.push(nums[i]);
         }
         return map;
        
    }
  
}