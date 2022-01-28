//https://leetcode-cn.com/problems/implement-stack-using-queues/
class MyStack {
    Queue<Integer> q = new LinkedList<>();
    int top_elem = 0;

    public MyStack() {

    }
    
    public void push(int x) {
        q.offer(x);
        top_elem = x;
    }
    
    public int pop() {
        //将队尾的元素弹出放到队头，最后poll的元素就是栈顶的元素
        int size = q.size();
        while(size>2) {
            q.offer(q.poll());
            size--;
        }
        //倒数第二个是新栈顶
        top_elem = q.peek();
        q.offer(q.poll());
        //倒数第一个是栈要pop出的栈顶
        return q.poll();
    }
    
    public int top() {
        return top_elem;
    }
    
    public boolean empty() {
        return q.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */