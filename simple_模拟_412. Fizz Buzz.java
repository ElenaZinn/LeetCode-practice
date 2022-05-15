//https://leetcode-cn.com/problems/fizz-buzz/
class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>();
        int i=1;
        while(i<=n) {
            StringBuilder s = new StringBuilder();
            if(i%3==0) { //是3 的倍数
                s.append("Fizz");
                if(i%5==0) { //同时是3 & 5的倍数
                    s.append("Buzz");
                }
                res.add(s.toString());
                i++;
                continue;
            }
            if(i%5==0) { //是5的倍数
                s.append("Buzz");
                res.add(s.toString());
                i++;
                continue;
            }
            res.add("" +i);
            i++;
        }
        return res;
        
    }
}