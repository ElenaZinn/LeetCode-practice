//https://leetcode-cn.com/problems/zhan-de-ya-ru-dan-chu-xu-lie-lcof/
/**
pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
模拟进栈与出栈
 */
class Solution {
    Deque<Integer> stack  = new LinkedList<>();
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int j=0; //表示弹出元素
        for(int i=0;i<pushed.length;i++) {
           stack.push(pushed[i]);
           while(!stack.isEmpty() && stack.peek()== popped[j]){
               stack.pop();
               j++;
           }
        }
        return stack.isEmpty();
    }
}