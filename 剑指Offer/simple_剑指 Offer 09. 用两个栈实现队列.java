//https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/
class CQueue {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public CQueue() {

    }
   
    public void appendTail(int value) {
        stack1.push(value);
    }
    
    public int deleteHead() {
        if (stack1.isEmpty() && stack2.isEmpty()) {
            return -1;
        }
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        if (stack2.isEmpty()) {
            return -1;
        }
        return stack2.pop();
    }
}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */