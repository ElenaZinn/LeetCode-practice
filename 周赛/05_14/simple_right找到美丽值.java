//https://leetcode.cn/problems/find-the-k-beauty-of-a-number/
class Solution {
    public int divisorSubstrings(int num, int k) {
        int count = 0;
        String s = String.valueOf(num);
        int index = 0;
        for(index = 0;index < s.length()-k+1;index++) {
            
            if( (Integer.parseInt(s.substring(index, index+k))!=0) && num % Integer.parseInt(s.substring(index, index+k))==0 ) {
                // System.out.println(Integer.parseInt(s.substring(index, index+k)));
                count++;
            }
            
        }
        return count;
    }
}