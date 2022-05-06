//https://leetcode-cn.com/problems/reverse-string-ii/
class Solution {
    public String reverseStr(String s, int k) {
        StringBuilder res = new StringBuilder();
        char[] ch = s.toCharArray();
        int start = 0; //四个一组呈现规律，start表示某个组的起始位置
        int i=0;
        while(i<ch.length) {
             if( i%k==0 && ch.length-i >=2*k  ) { //2*k个一组,后面超过2k个数
                //反转前k个
                int j=0;
                while(j<k) {
                    res.append("" + ch[i+k-j-1]);
                    j++;
                }
                //后面顺序不变
                j=0;
                while(j<k) {
                    res.append("" + ch[i+k+j]);
                    j++;
                }
                i+=2*k;
            }else if(ch.length-i <= k) {  //字符数小于k个,全部反转
                int j=0;
                while(j<ch.length-i ) {
                    res.append("" + ch[ch.length-j-1]);
                    j++;
                }
                return res.toString();
            }else if( ch.length-i > k && ch.length-i <2*k ) { //剩余字符数小于 2k 但大于或等于 k 个              //反转前k个
                int j=0;
                while(j<k) {
                    res.append("" + ch[i+k-j-1]);
                    j++;
                }

                //后面顺序不变
                j=0;
                while(j<ch.length-i-k) {
                    res.append("" + ch[k+i+j]);
                    j++;
                }
                return res.toString();
            }
        }
        return res.toString();
       
    }
}