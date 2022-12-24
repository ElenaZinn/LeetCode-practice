/**
 *2^10 = 2^5 * 2^5 = 2^5 * (2 * 2 ^4) = 2^5 * (2 * 2 ^2 * 2^2)  = 2^5 * (2 * 2 ^2 * (2*2)) 
  2^-2 = (1/2)^2
 */
class Solution {
    public double myPow(double x, int n) {
        if (n==0) return 1;
        if (n==Integer.MIN_VALUE) { //-k 因为会溢出
            return myPow(1/x, -(n+1))/x;
        }

        if (n <0) {
            return myPow(1/x, -n);
        }
        if (n%2 ==1) {//k is odd;
            return (x * myPow(x, n-1));
        } else { //k is even;   
            double sub = myPow(x,n/2);
            return sub * sub;
        }
    }
}