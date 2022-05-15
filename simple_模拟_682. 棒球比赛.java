//link:  https://leetcode-cn.com/problems/baseball-game/solution/
//思路：栈模拟
//使用deque比栈好： https://blog.csdn.net/linysuccess/article/details/109038453
class Solution {
    public int calPoints(String[] ops) {
        Deque<Integer> record = new LinkedList<>();
        for (int i=0;i<ops.length;i++) {
            String op = ops[i];
            if(op.equals("C")){
                record.pop();
            }else if(op.equals("D")){
                record.push(record.peek() *2);
            }else if(op.equals("+")) {
                int tmp = record.pop();
                int tmp2 = record.peek();
                record.push(tmp);
                record.push(tmp + tmp2);
            }else{
                record.push(Integer.parseInt(op));
            }
        }
        int sum = 0;
        while (!record.isEmpty()) {
            sum += record.pop();
        }
        return sum;
    }
}