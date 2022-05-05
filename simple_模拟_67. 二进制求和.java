//https://leetcode-cn.com/problems/add-binary/
/**
int val = a-'0'
   1 1
     1
   1 0
   1
 1 0 0

   1 0 1 0
   1 0 1 1
         1
     1 0
     1
  1 0  
 */
class Solution {
    /**  还可以再合并，目前的结果也有些错误
    int[] res;
    public String addBinary(String a, String b) {
        int m = a.length(), n = b.length();
        res = new int[m+n]; //长度不会超过m+n
        Arrays.fill(res,0);
        //一个数组长，一个数组短怎么半呀？
        int len = Math.min(m,n);
        int sum = 0,pos1=len;
        for(int i=m-1,j=n-1; i>0|| j>0 ; i--,j--) {
            if(i <0) { //a更短             !!!优化：使用三元组表示
                sum = (int) (b.charAt(j)-'0');
            }else if(j<0) {//b 更短
                sum = (int) (a.charAt(i)-'0');
            }else {//a b 在某个位都有值
                sum = (int) (a.charAt(i)-'0') + (int) (b.charAt(j)-'0');
            }
            int total = sum + res[pos1];  //之前已经求得的值+和
            System.out.println("total = " +total);
            if(total ==1) {//1+0=1不进位      !!!优化：使用carry表示是否进位，把进位放到total的计算中去
                res[pos1] = 1;
            }else if(total> 1) { //1+1=2 进位
                res[pos1]  =0;
                res[pos1-1] += 1;
            }else if(total==0) { //0+0=0 
                res[pos1] = 0;
            }
            pos1--;
        }
        //res数组前面还有为0的数值
        int k=0;
        while(k<m+n && res[k]==0) {
            k++;
        }
        StringBuilder sb = new StringBuilder("");
        for(int j=k;j<res.length;j++) {
            char c = (char)( '0'+res[j] );
            sb.append(c);
        }
       return sb.toString().length()== 0 ? "0" : sb.toString();
    }
    */
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int m = a.length()-1, n = b.length()-1;
        int carry = 0; //表示是否进位
        for(int i=m,j=n; i>=0|| j>=0 ; i--,j--) {
            int num1 = i>=0 ? a.charAt(i)-'0':0;
            int num2 = j>=0 ? b.charAt(j)-'0':0;
            int sum = num1+num2 + carry;
            carry= sum>=2? 1:0; //>=2 才进位
            sum = sum >= 2 ? sum - 2 : sum; // 去除进位后留下的数字
            sb.append(sum); // 把去除进位后留下的数字拼接到结果中
        }
        if(carry==1) { //最后一个进位
            sb.append(1);
        }
        return sb.reverse().toString();
    }
}