//https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
//hint:快慢指针

/**
example
nums = [0,0,1,1,1,2,2,3,3,4]
fast = 0, slow = 0
loop(1) fast= 1, slow = 0;
loop(2) nums[fast]=nums[slow =0], fast = 2
loop(3) nums[fast =2 ]!= nums[slow = 0],slow = 1,nums =[0,1',1*,1,1,2,2,3,3,4],left = 3
loop(4) nums[fast =3 ]=nums[slow =1],fast = 4
loop(5) nums[fast =4 ]=nums[slow =1],fast = 5
loop(6) nums[fast =5 ]!=nums[slow =1],slow = 2,nums =[0,1,2',1,1,2*,2,3,3,4],left = 6
loop(7) nums[fast =6 ]=nums[slow =2],fast = 7
loop(8) nums[fast =7 ]!=nums[slow =2],slow = 3,nums =[0,1,2,3',1,2,2,3*,3,4],left = 8
loop(9) nums[fast = 8]=nums[slow =3],fast = 9
loop(10) nums[fast =9 ]!=nums[slow =3],slow = 4,nums =[0,1,2,3,4',2,2,3,3,4*],left = 8
loop finish, return slow+1=5;
 */
class Solution {
    public int removeDuplicates(int[] nums) {
        int fast=0,slow = 0;
        int length = nums.length;
        while(fast < length) {
            if(nums[fast] != nums[slow]) {
                slow++;
                System.out.println("nums[" + slow + "] = " + nums[slow] + " nums[" +fast + "] = " + nums[fast]  );
                nums[slow] = nums[fast];
                System.out.println("nums[slow] = " + nums[slow]  );
                printNum(nums);
            }
            fast++;
        }
        return slow + 1;
    }
    public void printNum(int[] nums){
        for(int num : nums) {
            System.out.print(num + "\t");
        }
        System.out.println("");
    }
}