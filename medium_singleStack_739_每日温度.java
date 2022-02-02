//https://leetcode-cn.com/problems/daily-temperatures/
/**
similar with https://leetcode-cn.com/problems/next-greater-element-i/ 
不同之处在于，value = 遇到下一个更大的索引之差
 */
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Map<Integer, Integer> nextGreater = nextGreaterHelper(temperatures);
        int[] res = new int[temperatures.length];
        for(int i=0; i< temperatures.length;i++){
            res[i] = nextGreater.get(i);
        }
        return res;
    }

    public Map<Integer, Integer> nextGreaterHelper(int[] nums){
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> nextGreater= new HashMap<>();
        for (int i=nums.length-1;i>=0;i--) {
            while((!stack.isEmpty()) && nums[stack.peek()] <= nums[i]) {
                stack.pop();
            }
            nextGreater.put(i,stack.isEmpty()? 0 : stack.peek()-i);
            stack.push(i);
        }
        return nextGreater;
    }
}