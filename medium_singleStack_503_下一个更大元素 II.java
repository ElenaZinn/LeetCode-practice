//https://leetcode-cn.com/problems/next-greater-element-ii/
/**
similar with https://leetcode-cn.com/problems/next-greater-element-i/ 
不同之处在于，索引要求模
 */
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        /**
        Map<Integer, Integer> nextGreater = nextGreaterHelper(nums);
        不能全部求完nextgreater再遍历到res中，因为循环数组会覆盖之前的值
         */ 
        Stack<Integer> stack = new Stack<>();
        int n = nums.length;
        int[] res = new int[n];
        for(int i=2*n-1; i>=0; i--) {
            while(!stack.isEmpty() && stack.peek() <= nums[i%n]) {
                stack.pop();
            }
            res[i%n] = stack.isEmpty()? -1: stack.peek();
            stack.push(nums[i%n]);
        }
    
        return res;

    }
}