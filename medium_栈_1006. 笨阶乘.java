//https://leetcode-cn.com/problems/clumsy-factorial/
/**
乘除立即算，加减入栈
 */
class Solution {
    public int clumsy(int n) {
        Deque<Integer> stack = new LinkedList<>();
        char[] op = new char[]{'*','/','+','-'};
        stack.push(n);
        for(int i=0;i<n;i++) {
            System.out.println("i=" + i);
            if(i>0 && i%4 == 0) {
                //-
                stack.push(i-n);
            }else if(i%4 == 1) { 
                //*，运算后更新值
                int tmp = stack.pop();
                stack.push(tmp*(n-i));
            }else if(i%4 == 2) {
                // /，运算后更新值
                int tmp = stack.pop();
                stack.push(tmp/(n-i));
            }else if(i%4 == 3) {
                // +
                stack.push(n-i);
            }
        }
        int sum =0;
        while(!stack.isEmpty()) {
            sum += stack.pop();
        }
        return sum;
    }
}