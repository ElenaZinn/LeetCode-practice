 //https://leetcode-cn.com/problems/corporate-flight-bookings/
class Solution {
 
    //注意编号从1开始
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] nums = new int[n];
        Difference diff = new Difference(nums);

        for (int[] booking: bookings){
            int left = booking[0]-1;
            int right = booking[1] - 1;
            int val = booking[2];
            diff.increase(left, right, val);
        }

        return diff.recovery();

    }

}
class Difference{
    private int[] diff;
    public Difference(int[] nums) {
        //nums = [3,4,6,2,4],diff = [3,1,2,-4,2]
        diff = new int[nums.length];
        diff[0] = nums[0];
        for (int i=1; i<nums.length; i++) {
            diff[i] = nums[i] - nums[0];
        }
    }
    public void increase(int left, int right, int val) {
        // num[1...3] 全部加3: nums = [3, 4+3, 6+3, 2+3 ,4 ], diff = [3, 1+3, 2, -4, 2-3]
        diff[left] += val;
        if (right + 1 <  diff.length) {
            diff[right +1] -=val;
        }

    }
    public int[] recovery() {
        int[] arr = new int[diff.length];
        arr[0] = diff[0];
        for ( int i=1; i<diff.length; i++ ) {
            arr[i] = arr[i-1] + diff[i];
        }
        return arr;
    }
}
