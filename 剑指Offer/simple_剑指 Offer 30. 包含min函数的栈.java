//https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof/submissions/
class MinStack {
    
    /** initialize your data structure here. */
    Stack<Integer> min = new Stack<>();
    Stack<Integer> stack = new Stack<>();
    public MinStack() {

    }
   
    public void push(int x) {
        //stack 正常放入
        stack.push(x);
       //最小的是空的，放入最小的；
       //如果不是空的，把更小的推进去
       if (min.isEmpty()) {
           min.push(x);
       }else{
           min.push(Math.min(x,min.peek()));
       }
    }
    
    public void pop() {
        stack.pop();
        min.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int min() {
        return min.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */