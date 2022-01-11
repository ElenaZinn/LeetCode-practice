class Solution {
    /**未下车来了新客人,且超出capacity
        trips = [[2,1,5],[3,3,7]], capacity = 4
        location:  1  2  3  4  5  6  7
        passenger  2  2  2+3>4
        res = false
     */
    /**下车后来了新客人
        trips = [[2,1,5],[3,5,7]], capacity = 3
        location:  1  2  3  4  5     6  7
        passenger  2  2  2  2  -2+3  3  3
        res = true
     */
    public boolean carPooling(int[][] trips, int capacity) {
        //最大值不好确定
        //得先用start_location排序
        int[] nums = new int[trips[1][2]];
        Difference diff  = new Difference(nums);

        return true;
    }
}

class Difference{
    private int[] diff;
    public Difference(int[] nums) {
        //nums = [3,4,6,2,4],diff = [3,1,2,-4,2]
        diff = new int[nums.length];
        diff[0] = nums[0];
        for (int i=1; i < nums.length; i++) {
            diff[i] = nums[i] - nums[0];
        }
    }
    public void increase(int left, int right, int val，int capacity) {
        // num[1...3] 全部加3: nums = [3, 4+3, 6+3, 2+3 ,4 ], diff = [3, 1+3, 2, -4, 2-3]
        diff[left] += val;
        if (right + 1 <  diff.length) {
            diff[right +1] -=val;
        }

    }
    public int[] recovery() {
        int[] arr = new int[diff.length];
        arr[0] = diff[0];
        for ( int i=1; i < diff.length; i++ ) {
            arr[i] = arr[i-1] + diff[i];
        }
        return arr;
    }
}
