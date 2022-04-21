//https://leetcode-cn.com/problems/multiply-strings/
/**
思路：模拟手算乘法
nums1的每一位与num2的个位相乘后，再用num1的每一位与nums2的十位相乘...依次类推-->使用num1[i], num2[j]双指针
两个个位数字相乘长度不超过，每次乘积都错位1个
对于每一位的计算结果，采用累加的形式存放在res中
res的index与num1,num2的索引的对应关系是: 累加加过存放在res[i+j] res[i+j+1]
 */
import java.util.*;
class Solution {
    
    public String multiply(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        int[] res = new int[m+n];//不会超过m+n的长度
        Arrays.fill(res,0);
        int base = 10; // 用来求得个、十位等的数字
        for(int i=m-1;i>=0;i--) {
            for(int j=n-1; j>=0;j--) {
                int mul = (num1.charAt(i)-'0') * (num2.charAt(j)-'0');
                int pos1 = i+j, pos2 = i+j+1;
                //叠加到res上
                int sum = mul + res[pos2]; 
                //模拟进位
                res[pos1] +=  sum / base;  //因为错开了一位，所以只有高位数有累加和（十位数相加）
                res[pos2]   = sum%base;  //个位
            }
        }
        //res数组的前半部分存在没有使用的位置
        //若第一位是0，会出现0在while循环里被剔除了
        int i=0;
        while(i<res.length && res[i]==0) {
            i++;
        }
        
        StringBuilder sb = new StringBuilder("");
        for(int j=i;j<res.length;j++) {
            char c = (char)( '0'+res[j] );
            sb.append(c);
        }
       return sb.toString().length()== 0 ? "0" : sb.toString();
        
    }
    
}