//https://leetcode-cn.com/problems/count-numbers-with-unique-digits/
/**
n=0, res =[0]
n=1,res = [1,2,3,4,5,6,7,8,9,10]
n=2, res= [除去11、22、33、44、55、66、77、88、99]
n=3, res = [除去11、22、33、44、55、66、77、88、99、111、222、333、444、555、666、777、888、999、112、113、121、112 211...] = 1000-9 -？
 */
 /**
f(0)=1
f(1)=10
f(2)=9x9+f(1)
f(3)=9x9x8+f(2)
f(4)=9x9x8x7+f(3)
  */
class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        //base case;
        if(n==0){
            return 1;
        }
        if(n==1){
            return 10;
        }
        int res = 10, cur = 9;
        for (int i = 0; i < n - 1; i++) {
            cur *= 9 - i;
            res += cur;
        }
        return res;
    }
}