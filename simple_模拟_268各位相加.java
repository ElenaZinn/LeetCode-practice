/**
*258. 各位相加
https://leetcode.cn/problems/add-digits/
*/
class Solution {
    public int addDigits(int num) {
        int res = add(num);
        //repeatly add 
        while(res/10>0) {
            res = add(res);
        }
        return res;
    }

    public int add (int num) {
        ArrayList<Integer> list = new ArrayList<>();
        int cal  = num;
        int res = 0;
        //get each digit
        while (cal/10 >0) {
            list.add(cal%10);
            cal = cal/10;
        }
        list.add(cal);
        //add
        for( int i=0;i < list.size(); i++) {
            res  +=  list.get(i);
        }
        return res;
    }
}