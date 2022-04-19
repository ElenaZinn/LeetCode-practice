class Solution {
    public boolean isPalindrome(int x) {
       
        int i,j;
        if(x<0) {
            return false;
        }
         /** 法一：先求出每个位数的数组，再判断
         优化：求出每个位数的数组时，求出反序的值，最后对比值就可以了
          ArrayList<Integer> arr = pos(x);
            for(i=0 ,j = arr.size()-1;i< arr.size() && j>=0;i++,j--){
                if(arr.get(i) != arr.get(j)){
                    return false;
                }
            }
          */
        int afterDivide = x;
        int reverse = 0;
        while(afterDivide!=0) {
            reverse = reverse *10 + afterDivide%10;
            afterDivide /=10;
        }
        return reverse == x;
    }
    public ArrayList<Integer> pos(int num){
        ArrayList<Integer> res = new ArrayList<>();
        //求得每一的数值，一个从前遍历一个从后遍历，如果不同则返回false
        int base = 10, afterDivide = num;
        while(afterDivide >0) {
            int digital = afterDivide%10;
            res.add(digital);
            afterDivide = afterDivide/10;
        }
        return res;
        
    }
}