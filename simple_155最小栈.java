//https://leetcode-cn.com/problems/min-stack/submissions/
class MinStack {
    
    Deque<Integer> xStack;
    Deque<Integer> minStack;
    public MinStack() {
        //inti stack
        xStack = new LinkedList<Integer>();
        minStack = new LinkedList<>();
        minStack.push(Integer.MAX_VALUE);
    }
    
    public void push(int val) {
        xStack.push(val);
        if(minStack.isEmpty() || val<=minStack.peek()) {//如果是最小值，入栈
            minStack.push(val);
        }
    }
    
    public void pop() {
        //如果minStack栈顶与xStack栈顶相同，两个都要出栈
        /**  // OK 
        int x =  xStack.peek();
        if(minStack.peek() == x) {
            minStack.pop();
        }
        xStack.pop();
        */
        /**
        //不OK,数据类型是int，==比较的应该是数值呀？
        if(minStack.peek() ==  xStack.peek()) {
            minStack.pop();
        }
        xStack.pop();
         */
        
        /** ?顺序不一样，为什么结果也不一样啊啊啊啊啊["MinStack","push","push","push","push","pop","getMin","pop","getMin","pop","getMin"]
[[],[512],[-1024],[-1024],[512],[],[],[],[],[],[]]  expected result = [null,null,null,null,null,null,-1024,null,-1024,null,512]
        */
        /**  
        // OK 
        int x = xStack.pop();
        if(minStack.peek()==x) {
            minStack.pop();
        }
        */
        
        
    }
    
    public int top() {
       return xStack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */