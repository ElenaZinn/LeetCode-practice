//https://leetcode-cn.com/problems/reverse-integer/
class Solution {
   /**
    -2147483412 出错，因为正负数的取值范围是有区别的，不能把负数取绝对值计算
    */
    public int reverse_self(int x) {
        int num = Math.abs(x);
        int mod=0, remain = num;
        int sum = 0;
        while(remain>0) {
            mod = remain%10;
            // System.out.print("mod = " + mod + "\t");
            sum = sum *10 + mod;
            // System.out.println("sum = " + sum);
            if (sum > Integer.MAX_VALUE / 10) { //因为有范围限制
                return 0;
            }
            remain = remain/10;
        }
    
        if(x>0) {
            return sum;
        }else{
            return -sum;
        }
    }
    public int reverse(int x) {
    
        int sum = 0;
        while(x!=0) {
            if (sum < Integer.MIN_VALUE/10 || sum > Integer.MAX_VALUE / 10) { //因为有范围限制
                return 0;
            }
            int mod = x%10;
            sum  = sum*10 +mod;
            x = x/10;
        }
        return sum;
    }
}