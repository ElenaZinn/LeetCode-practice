// link: https://leetcode-cn.com/problems/jump-game-ii/
/**
example
[2,3,1,1,4]
i =0 , farthest = 2
    end: 0-->2. jumps = 1
i = 1, farthest = nums[1] +1 = 4
i = 2, farthest = 4
    end:2-->4, jumps = 2
i=3, farthest = 4 
 */
class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int end = 0, farthest =0;
        int jumps = 0;
        for (int i=0;i<n-1;i++) {
            System.out.println("in for loop, i = " + i);
            farthest = Math.max(nums[i] +i, farthest);
            System.out.println("farthest = " + farthest);
            if(end==i) {
                 System.out.println("in if, now end==i, end == " + end + " jumps = " + jumps + " fathest = " + farthest);
                jumps ++;
                end = farthest;
                System.out.println("in if, end == " + end + " jumps = " + jumps + " fathest = " + farthest);
            }
        }
        return jumps;
    }
}